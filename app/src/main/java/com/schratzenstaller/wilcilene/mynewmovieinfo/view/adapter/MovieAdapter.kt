package com.schratzenstaller.wilcilene.mynewmovieinfo.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.schratzenstaller.wilcilene.mynewmovieinfo.R
import com.schratzenstaller.wilcilene.mynewmovieinfo.domain.Movie
import com.schratzenstaller.wilcilene.mynewmovieinfo.view.utils.ClassOnClickListener

class MovieAdapter(
    private val items: List<Movie?>, private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)

        return ViewHolder(view, onItemClickListener)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        if (item != null) {
            holder.bindView(item, onItemClickListener)
        }
    }

    class ViewHolder(itemView: View, onItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Movie?, onItemClickListener: OnItemClickListener) = with(itemView) {
            val ivMoviePoster = findViewById<ImageView>(R.id.ivMoviePoster)
            val tvMovieTitle = findViewById<TextView>(R.id.tvMovieTitle)
            val tvVoteAverage = findViewById<TextView>(R.id.tvVoteAverage)

            item?.let {
                var urlMoviePoster = "https://image.tmdb.org/t/p/original" + item.posterPath
                if (item.posterPath.isNullOrBlank()) {
                    urlMoviePoster = "https://i.redd.it/ds1luav7dl851.jpg"
                }

                Glide.with(itemView.context).load(urlMoviePoster).into(ivMoviePoster)
                tvMovieTitle.text = item.title
                tvVoteAverage.text = item.voteAverage
                //tvVoteAverage.text = "${item.vote_average}%"

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
