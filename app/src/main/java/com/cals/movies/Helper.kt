package com.cals.movies

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

object Helper {

    const val TYPE_MOVIE = "TYPE_MOVIE"
    const val TYPE_TV = "TYPE_TV"

    fun setGlideImage(context: Context, imagePath: Int, imageView: ImageView){
        Glide.with(context).clear(imageView)
        Glide.with(context).load(imagePath).into(imageView)
    }
}