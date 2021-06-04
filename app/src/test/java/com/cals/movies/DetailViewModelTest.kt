package com.cals.movies

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test



class DetailViewModelTest{
    private lateinit var detailViewModel: DetailViewModel

    private val staticMovie = DataStatic.generateStaticMovie()[0]
    private val moviesId = staticMovie.id

    private val staticTvShows = DataStatic.generateStaticTvShow()[0]
    private val tvShowId = staticTvShows.id

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel()
        detailViewModel.setMovieId(moviesId)
        detailViewModel.setTvShowId(tvShowId)
    }

    @Test
    fun getDetailMovieById() {
        detailViewModel.setMovieId(moviesId)
        val movies = detailViewModel.getDetailMovieById()
        assertNotNull(movies)
        assertEquals(staticMovie.title, movies.title)
        assertEquals(staticMovie.genre, movies.genre)
        assertEquals(staticMovie.release_date, movies.release_date)
        assertEquals(staticMovie.description, movies.description)
        assertEquals(staticMovie.img_poster, movies.img_poster)
    }

    @Test
    fun getDetailTvShowById() {
        detailViewModel.setTvShowId(tvShowId)
        val tvShows = detailViewModel.getDetailTvShowById()
        assertNotNull(tvShows)
        assertEquals(staticTvShows.title, tvShows.title)
        assertEquals(staticTvShows.genre, tvShows.genre)
        assertEquals(staticTvShows.release_date, tvShows.release_date)
        assertEquals(staticTvShows.description, tvShows.description)
        assertEquals(staticTvShows.img_poster, tvShows.img_poster)

    }
}