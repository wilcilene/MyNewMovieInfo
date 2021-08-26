package com.schratzenstaller.wilcilene.mynewmovieinfo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.schratzenstaller.wilcilene.mynewmovieinfo.databinding.ActivityMovieDetailBinding
import com.schratzenstaller.wilcilene.mynewmovieinfo.domain.MovieDetail
import com.schratzenstaller.wilcilene.mynewmovieinfo.view.adapter.MovieDetailCastAdapter
import com.schratzenstaller.wilcilene.mynewmovieinfo.view.adapter.MovieDetailGenreAdapter
import com.schratzenstaller.wilcilene.mynewmovieinfo.viewmodel.MovieDetailViewModel
import com.schratzenstaller.wilcilene.mynewmovieinfo.viewmodel.MovieDetailViewModelFactory

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val movieId = intent.extras?.getString("MOVIE_ID")

        val detailViewModel =
            ViewModelProvider(this, MovieDetailViewModelFactory(movieId.toString()))
                .get(MovieDetailViewModel::class.java)

        detailViewModel.movieDetail.observe(this, Observer {
            setupMovieDetail(it)
            setupRecyclerViewGenre(it)
            setupRecyclerViewCast(it)
        })
    }

    private fun setupMovieDetail(it: MovieDetail?) {

        if (it != null) {
            binding.tvVoteAverage.text = it.voteAverage

            binding.tvMovieDetailTitle.text = it.title

            binding.tvReleaseYear.text = it.releaseDate

            var urlMoviePoster = "https://image.tmdb.org/t/p/original" + it.backdrop_path
            if (it.backdrop_path.isNullOrBlank()) {
                urlMoviePoster = "https://i.redd.it/ds1luav7dl851.jpg"
            }
            Glide.with(binding.ivMoviePoster.context).load(urlMoviePoster)
                .into(binding.ivMoviePoster)

            binding.tvRuntime.text = it.runtimeFormatted

            binding.tvOverviewText.text = it.overview
        }
    }

    private fun setupRecyclerViewGenre(it: MovieDetail?) {
        binding.rvMovieGenres.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
        false)

        if (it != null) {
            binding.rvMovieGenres.adapter =
                it.let { it.genres?.let { genre -> MovieDetailGenreAdapter(genre) } }
        }
    }

    private fun setupRecyclerViewCast(it: MovieDetail?) {

        binding.rvCast.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false)

        if (it != null) {
            binding.rvCast.adapter =
                it.let { it.credits?.let { cast -> MovieDetailCastAdapter(cast) } }
        }
    }
}