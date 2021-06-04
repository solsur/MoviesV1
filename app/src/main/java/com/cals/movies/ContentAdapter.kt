package com.cals.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_item.view.*

class ContentAdapter (private val callback: ContentCallback): RecyclerView.Adapter<ContentAdapter.ListViewHolder>() {

    private val listData = ArrayList<DataModel>()

    fun setData(data: List<DataModel>){
        listData.clear()
        listData.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder = ListViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
    )

    override fun onBindViewHolder(holder: ContentAdapter.ListViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size


    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(data: DataModel){
            with(itemView){
                tv_title.text = data.title
                tv_genre.text = data.genre
                tv_release.text = data.release_date

                Glide.with(itemView.context)
                    .load(data.img_poster)
                    .into(img_user)

                item_card.setOnClickListener{
                    callback.onItemClicked(data)
                }
            }
        }

    }





}