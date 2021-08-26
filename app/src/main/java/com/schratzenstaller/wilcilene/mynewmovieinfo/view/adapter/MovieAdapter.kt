package com.schratzenstaller.wilcilene.mynewmovieinfo.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.schratzenstaller.wilcilene.mynewmovieinfo.databinding.ItemMovieBinding
import com.schratzenstaller.wilcilene.mynewmovieinfo.domain.Movie

class MovieAdapter(
    private val items: List<Movie?>, private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val viewBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)

        return ViewHolder(viewBinding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item, onItemClickListener)
    }

    inner class ViewHolder(private val itemBinding: ItemMovieBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bindView(item: Movie?, onItemClickListener: OnItemClickListener) = with (itemBinding){

            item?.let {

                var urlMoviePoster = "https://image.tmdb.org/t/p/original" + item.posterPath
                if (item.posterPath.isNullOrBlank()) {
                    urlMoviePoster = "https://i.redd.it/ds1luav7dl851.jpg"
                }

                Glide.with(itemView.context).load(urlMoviePoster).into(ivMoviePoster)

                tvMovieTitle.text = item.title

                tvVoteAverage.text = item.voteAverage

                ivMoviePoster.setOnClickListener {
                    onItemClickListener.onClick(item)
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onClick(movie: Movie)
    }
}
