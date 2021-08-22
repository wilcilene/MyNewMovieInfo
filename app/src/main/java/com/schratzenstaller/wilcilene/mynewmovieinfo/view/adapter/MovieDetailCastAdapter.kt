package com.schratzenstaller.wilcilene.mynewmovieinfo.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.schratzenstaller.wilcilene.mynewmovieinfo.databinding.ItemCastBinding
import com.schratzenstaller.wilcilene.mynewmovieinfo.domain.Cast

class MovieDetailCastAdapter(
    private val items: List<Cast?>
) : RecyclerView.Adapter<MovieDetailCastAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemCastBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(viewBinding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    inner class ViewHolder(private val itemBinding: ItemCastBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindView(item: Cast?) = with(itemBinding) {

            item?.let {

                var photoCast = "https://image.tmdb.org/t/p/original" + item.profile_path
                if (item.profile_path.isNullOrBlank()) {
                    photoCast = "https://i.redd.it/ds1luav7dl851.jpg"
                }
                Glide.with(itemView.context).load(photoCast).into(civCastPerson)

                tvNameCast.text = item.name

                tvJobCast.text = item.character
            }
        }
    }
}