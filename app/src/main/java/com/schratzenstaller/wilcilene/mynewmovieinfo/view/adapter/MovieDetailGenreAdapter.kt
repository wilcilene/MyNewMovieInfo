package com.schratzenstaller.wilcilene.mynewmovieinfo.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.schratzenstaller.wilcilene.mynewmovieinfo.databinding.ItemGenreBinding
import com.schratzenstaller.wilcilene.mynewmovieinfo.domain.Genre

class MovieDetailGenreAdapter(
    private val items: List<Genre?>
) : RecyclerView.Adapter<MovieDetailGenreAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemGenreBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)

        return ViewHolder(viewBinding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    inner class ViewHolder(private val itemBinding: ItemGenreBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bindView(item: Genre?) = with (itemBinding){
            if (item != null) {
//                chipGenres.setChipBackgroundColor("#223344")
                chipGenres.text = item.name
            }
        }
    }
}