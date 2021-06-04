@file:Suppress("DEPRECATION")

package com.cals.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.cals.movies.Helper.TYPE_MOVIE
import kotlinx.android.synthetic.main.fragment_movie.*


class MovieFragment : Fragment(), ContentCallback {

    private lateinit var  viewModel: ContentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.let {
            viewModel = ViewModelProvider(it, ViewModelProvider.NewInstanceFactory())[ContentViewModel::class.java]

        }

        val listMovie = viewModel.getListMovie()
        setRecylerView(listMovie)
    }

    private fun setRecylerView(data: List<DataModel>) {
        rv_movie.apply {
            layoutManager = GridLayoutManager(context, 1)
            adapter = ContentAdapter(this@MovieFragment)
            setHasFixedSize(true)
        }.also {
            it.adapter.let {
                adapter ->
                when (adapter){
                    is ContentAdapter -> {
                        adapter.setData(data)
                    }
                }
            }
        }

    }

    override fun onItemClicked(data: DataModel) {
        startActivity(
            Intent(context, DetailActivity::class.java)
                .putExtra(DetailActivity.EXTRA_DATA, data.id)
                .putExtra(DetailActivity.EXTRA_TYPE, TYPE_MOVIE)
        )
    }
}