package com.cals.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.cals.movies.Helper.TYPE_MOVIE
import com.cals.movies.Helper.TYPE_TV
import com.cals.movies.Helper.setGlideImage
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var  resultDetail : DataModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val viewModel = ViewModelProvider(this@DetailActivity, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        supportActionBar?.title = "Detail Film"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id = intent.getStringExtra(EXTRA_DATA)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MOVIE, ignoreCase = true)){
            id?.let {
                viewModel.setMovieId(it)
            }
            resultDetail = viewModel.getDetailMovieById()

        } else if (type.equals(TYPE_TV, ignoreCase = true)){
            id?.let {
                viewModel.setTvShowId(it)
            }
            resultDetail = viewModel.getDetailTvShowById()
        }

        tv_item_title.text = resultDetail.title
        tv_item_overview.text = resultDetail.description
        tv_item_release.text = resultDetail.release_date
        tv_item_genre.text = resultDetail.genre
        setGlideImage(this@DetailActivity, resultDetail.img_poster, img_detail)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}