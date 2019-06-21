package com.yazan98.vortex.android.extras.ui

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.common.ResizeOptions
import com.facebook.imagepipeline.request.ImageRequestBuilder
import com.squareup.picasso.Picasso

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 1:28 PM
 */

object VortexImageLoaders {

    fun loadImageWithPicasso(url: String, image: ImageView) {
        Picasso.get()
            .load(url)
            .into(image)
    }

    fun loadImageWithGlide(url: String, image: ImageView, context: Context) {
        Glide.with(context)
            .load(url)
            .into(image)
    }

    fun loadImageWithFresco(url: String, image: SimpleDraweeView) {
        image.setImageURI(Uri.parse(url))
    }

    fun loadLargeImageWithFresco(url: String, image: SimpleDraweeView, width: Int, height: Int) {
        val request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
            .setResizeOptions(ResizeOptions(width, height))
            .build()
        image.controller = Fresco.newDraweeControllerBuilder()
            .setOldController(image.controller)
            .setImageRequest(request)
            .build()
    }

}
