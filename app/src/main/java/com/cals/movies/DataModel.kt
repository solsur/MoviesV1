package com.cals.movies

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataModel(
    var id: String,
    var title: String,
    var genre: String,
    var description: String,
    var release_date: String,
    var img_poster: Int
) : Parcelable
