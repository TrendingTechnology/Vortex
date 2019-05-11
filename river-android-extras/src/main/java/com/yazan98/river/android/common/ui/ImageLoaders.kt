
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
package com.yazan98.river.android.common.ui

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
 * Created By : Yazan Tarifi
 * Date : 02/05/2019
 * Time : 18:40
 */
object ImageLoaders {

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
