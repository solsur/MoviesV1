package com.cals.movies

import androidx.lifecycle.ViewModel

class ContentViewModel : ViewModel() {

    fun getListMovie(): List<DataModel> = DataStatic.generateStaticMovie()
    fun getListTvShow(): List<DataModel> = DataStatic.generateStaticTvShow()
}