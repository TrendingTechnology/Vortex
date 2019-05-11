
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
package com.yazan98.river.android.common.utils

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v4.media.MediaBrowserCompat
import androidx.core.app.NotificationCompat
import timber.log.Timber
import java.util.*

/**
 * Created By : Yazan Tarifi
 * Date : 02/05/2019
 * Time : 21:15
 */

object NotificationUtils {

    private var notificationId = 0
    private var notificationIntent: Intent? = null
    private var contentIntent: PendingIntent? = null
    private var notificationManager: NotificationManager? = null
    private var res: Resources? = null
    private var builder: Notification.Builder? = null
    private var notif: Notification? = null
    private var notificationInboxStyle: Notification.InboxStyle? = null
    private var resultIntent: Intent? = null
    private var inboxStyle: NotificationCompat.InboxStyle? = null
    private var bigTextNotificationStyle: NotificationCompat.BigTextStyle? = null
    private var currentIcon: Bitmap? = null

    fun showNotificationWithIntent(
        title: String, content: String, context: Context, smallIcon: Int,
        largeIcon: Int, reqCode: Int, targetClass: Class<*>
    ) {
        notificationIntent = Intent(context, targetClass)
        contentIntent = PendingIntent.getActivity(
            context,
            reqCode, notificationIntent,
            PendingIntent.FLAG_CANCEL_CURRENT
        )

        notificationManager = context
            .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?

        res = context.getResources()
        builder = Notification.Builder(context)

        builder!!.setContentIntent(contentIntent)
            .setSmallIcon(smallIcon)
            .setLargeIcon(BitmapFactory.decodeResource(res, largeIcon))
            .setWhen(System.currentTimeMillis())
            .setAutoCancel(true)
            .setContentTitle(title)
            .setContentText(content)

        val n = builder!!.build()
        notificationManager!!.notify(notificationId, n)
        notificationId++
        Timber.d("Notification ID = $notificationId : Normal Message Status")
    }

    fun showTextNotification(context: Context, channelId: String, smallIcon: Int, title: String, content: String) {
        var mBuilder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(smallIcon)
            .setContentTitle(title)
            .setContentText(content)
        notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
        notificationManager!!.notify(notificationId, mBuilder!!.build())
        notificationId++
    }


    fun showExpandLayoutNotificationText(context: Context, title: String, content: String, smallIcon: Int) {
        notificationInboxStyle = Notification.InboxStyle()
        notif = Notification.Builder(context)
            .setContentTitle(title)
            .setContentText(content)
            .setSmallIcon(smallIcon)
            .setStyle(notificationInboxStyle)
            .build()
    }

    fun showExpandLayoutNotificationWithIntent(
        context: Context, target: Class<*>, title: String,
        clannelId: String, smallIcon: Int, content: String, @MediaBrowserCompat.MediaItem.Flags flags: Int
    ) {
        resultIntent = Intent(context, target)
        resultIntent!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        contentIntent =
            PendingIntent.getActivity(context, Calendar.getInstance().getTimeInMillis() as Int, resultIntent, flags)
        inboxStyle = NotificationCompat.InboxStyle()
        inboxStyle!!.setBigContentTitle(title)
        val mBuilder = NotificationCompat.Builder(context, clannelId)
            .setSmallIcon(smallIcon)
            .setContentTitle(title)
            .setContentText(content)
            .setStyle(inboxStyle)
            .addAction(smallIcon, title, contentIntent)
        notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
        notificationManager!!.notify(notificationId, mBuilder.build())
        notificationId++
    }

    fun showBigTextNotificationStyle(
        context: Context, bigImage: Int, bigText: String, content: String,
        isSummeryEnabled: Boolean, summery: String, clannelId: String, smallIcon: Int, title: String
    ) {
        currentIcon = BitmapFactory.decodeResource(context.getResources(), bigImage)

        bigTextNotificationStyle = NotificationCompat.BigTextStyle()
        bigTextNotificationStyle!!.bigText(bigText)
        bigTextNotificationStyle!!.setBigContentTitle(content)
        if (isSummeryEnabled) {
            bigTextNotificationStyle!!.setSummaryText(summery)
        }
        var mBuilder = NotificationCompat.Builder(context, clannelId)
            .setSmallIcon(smallIcon)
            .setContentTitle(title)
            .setContentText(content)
            .setLargeIcon(currentIcon)
            .setStyle(bigTextNotificationStyle)

        notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
        notificationManager!!.notify(notificationId, mBuilder!!.build())
        notificationId++
    }

    fun addLineToNotificationInbox(newLine: String) {
        if (notificationInboxStyle != null) {
            notificationInboxStyle!!.addLine(newLine)
        }
    }

}
