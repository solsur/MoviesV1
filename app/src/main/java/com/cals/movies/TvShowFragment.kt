@file:Suppress("DEPRECATION")

package com.cals.movies

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TvShowFragment : Fragment(), ContentCallback {

    private lateinit var  viewModel: ContentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.let {
            viewModel = ViewModelProvider(it, ViewModelProvider.NewInstanceFactory())[ContentViewModel::class.java]

        }

        val listTvShow = viewModel.getListTvShow()
        setRecylerView(listTvShow)
    }

    private fun setRecylerView(data: List<DataModel>) {
        rv_tv_show.apply {
            layoutManager = GridLayoutManager(context, 1)
            adapter = ContentAdapter(this@TvShowFragment)
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
                .putExtra(DetailActivity.EXTRA_TYPE, Helper.TYPE_TV)
        )
    }
}

