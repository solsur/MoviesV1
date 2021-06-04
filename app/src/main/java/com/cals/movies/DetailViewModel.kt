package com.cals.movies

import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {

    private lateinit var moviesId: String
    private lateinit var tvShowsId: String

    private fun getListMovie(): ArrayList<DataModel> =
        DataStatic.generateStaticMovie() as ArrayList<DataModel>

    private fun getListTvShow(): ArrayList<DataModel> =
        DataStatic.generateStaticTvShow() as ArrayList<DataModel>

    fun setMovieId(moviesId: String){
        this.moviesId = moviesId
    }

    fun setTvShowId(tvShowsId: String){
        this.tvShowsId = tvShowsId
    }

    fun getDetailMovieById(): DataModel{
        lateinit var result: DataModel
        val listMovies = getListMovie()
        for (movies in listMovies){
            if (movies.id == moviesId){
                result = movies
                break
            }
        }
        return result
    }

    fun getDetailTvShowById(): DataModel{
        lateinit var result: DataModel
        val listTvShows = getListTvShow()
        for (tvShows in listTvShows){
            if (tvShows.id == tvShowsId){
                result = tvShows
                break
            }
        }
        return result
    }
}