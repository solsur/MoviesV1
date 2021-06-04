@file:Suppress("DEPRECATION")

package com.cals.movies

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@Suppress("DEPRECATION")
@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    private val staticMovie = DataStatic.generateStaticMovie()
    private val staticTvShow = DataStatic.generateStaticTvShow()

    @get:Rule
    var ruleActivity = ActivityTestRule(MainActivity::class.java)


    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(staticMovie.size))
    }

    @Test
    fun loadDetailMovie(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_item_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_title)).check(matches(withText(staticMovie[0].title)))
        onView(withId(R.id.tv_item_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_release)).check(matches(withText(staticMovie[0].release_date)))
        onView(withId(R.id.tv_item_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_overview)).check(matches(withText(staticMovie[0].description)))
        onView(withId(R.id.tv_item_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_genre)).check(matches(withText(staticMovie[0].genre)))
        onView(withId(R.id.img_detail)).check(matches(isDisplayed()))

    }

    @Test
    fun loadTvShows(){
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(staticTvShow.size))
    }

    @Test
    fun loadDetailTvShows(){
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_item_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_title)).check(matches(withText(staticTvShow[0].title)))
        onView(withId(R.id.tv_item_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_release)).check(matches(withText(staticTvShow[0].release_date)))
        onView(withId(R.id.tv_item_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_overview)).check(matches(withText(staticTvShow[0].description)))
        onView(withId(R.id.tv_item_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_genre)).check(matches(withText(staticTvShow[0].genre)))
        onView(withId(R.id.img_detail)).check(matches(isDisplayed()))

    }

}