package com.cals.movies


import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class ContentViewModelTest{

    private lateinit var viewModel: ContentViewModel

    @Before
    fun setUp(){
        viewModel = ContentViewModel()
    }

    @Test
    fun testGetListMovie() {
        val movies = viewModel.getListMovie()
        assertNotNull(movies)
        assertEquals(10, movies.size)
    }

    @Test
    fun testGetListTvShow() {
        val tvShows = viewModel.getListTvShow()
        assertNotNull(tvShows)
        assertEquals(10, tvShows.size)
    }
}