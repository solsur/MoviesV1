package com.cals.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolBar)
        supportActionBar?.title = "Movies Catalogue"
        supportActionBar?.elevation = 0f

        val pagerAdapter = PagerAdapter(this, supportFragmentManager)
        viewPager.adapter = pagerAdapter
        tab_layout.setupWithViewPager(viewPager)
    }
}