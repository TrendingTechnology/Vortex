
/**
 *    Copyright [2019] [Yazan Tarifi]
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.yazan98.river.android.common.listeners

import android.Manifest
import android.annotation.SuppressLint
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Looper
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.*
import com.yazan98.river.android.common.utils.LocationUtils
import com.yt98.zedra.ui.listeners.LocationServiceInfo
import timber.log.Timber

/**
 * Created By : Yazan Tarifi
 * Date : 5/4/2019
 * Time : 8:14 PM
 */

abstract class BaseLocationService : Service(), LocationListener {

    private lateinit var locationManager: LocationManager

    override fun onProviderEnabled(provider: String?) {
        getGpsStatusListener().onProviderEnabled()
    }

    override fun onProviderDisabled(provider: String?) {
        getGpsStatusListener().onProviderDisabled()
    }

    /**
     * Contains parameters used by [com.google.android.gms.location.FusedLocationProviderApi].
     */
    private lateinit var mLocationRequest: LocationRequest

    /**
     * Provides access to the Fused Location Provider API.
     */
    private lateinit var mFusedLocationClient: FusedLocationProviderClient
    private lateinit var mChangingLocationCallback: LocationCallback
    private lateinit var mCurrentLocation: Location

    override fun onCreate() {
        super.onCreate()
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        setCallbackLocation()
        createLocationRequest()
        getLastLocation()

        var criteria = Criteria()
        criteria.accuracy = Criteria.ACCURACY_COARSE
        criteria.isAltitudeRequired = false
        criteria.isBearingRequired = false
        criteria.isCostAllowed = true
        criteria.powerRequirement = loadServiceInfo().criteria

        var provider = locationManager.getBestProvider(criteria, true)

        if (::locationManager.isInitialized) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            locationManager.requestLocationUpdates(
                provider,
                loadServiceInfo().minTime,
                loadServiceInfo().minDistance,
                this
            )
        }
    }

    /**
     * Makes a request for location updates. Note that in this sample we merely log the
     * [SecurityException].
     */
    fun requestLocationUpdates() {
        LocationUtils.setRequestingLocationUpdates(this, true)
        startService(Intent(applicationContext, loadServiceInfo().serviceTargetClass))
        try {
            mFusedLocationClient.requestLocationUpdates(
                mLocationRequest,
                mChangingLocationCallback, Looper.myLooper()
            )

            if (::mCurrentLocation.isInitialized) {
                onNewLocation(mCurrentLocation)
            }

        } catch (unlikely: SecurityException) {
            LocationUtils.setRequestingLocationUpdates(this, false)
        }

    }

    @SuppressLint("LogNotTimber")
    private fun getLastLocation() {
        try {
            mFusedLocationClient!!.lastLocation
                .addOnCompleteListener { task ->
                    if (task.isSuccessful && task.result != null) {
                        mCurrentLocation = task.result!!
                    }
                }
        } catch (unlikely: SecurityException) {
            Timber.e("Lost location permission. ${unlikely.message}")
        }

    }

    private fun onNewLocation(location: Location) {
        onLocation(location)
    }

    /**
     * Sets the location request parameters.
     */
    private fun createLocationRequest() {
        mLocationRequest = LocationRequest.create()
        mLocationRequest.interval = loadServiceInfo().interval
        mLocationRequest.fastestInterval = loadServiceInfo().fastestInterval
        mLocationRequest.priority = loadServiceInfo().priority
    }


    private fun setCallbackLocation() {
        mChangingLocationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                super.onLocationResult(locationResult)
                onNewLocation(locationResult.lastLocation)
            }
        }
    }


    protected abstract fun onLocation(location: Location)
    protected abstract fun loadServiceInfo(): LocationServiceInfo
    protected abstract fun getGpsStatusListener(): GpsStatusListener

}
