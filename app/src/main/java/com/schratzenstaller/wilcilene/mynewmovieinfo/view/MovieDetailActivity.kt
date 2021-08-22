package com.schratzenstaller.wilcilene.mynewmovieinfo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.schratzenstaller.wilcilene.mynewmovieinfo.databinding.ActivityMovieDetailBinding
import com.schratzenstaller.wilcilene.mynewmovieinfo.domain.MovieDetail
import com.schratzenstaller.wilcilene.mynewmovieinfo.view.adapter.MovieDetailCastAdapter
import com.schratzenstaller.wilcilene.mynewmovieinfo.view.adapter.MovieDetailGenreAdapter
import com.schratzenstaller.wilcilene.mynewmovieinfo.viewmodel.*

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var detailViewModel =
            ViewModelProvider(this, MovieDetailViewModelFactory())
                .get(MovieDetailViewModel::class.java)

        detailViewModel.movieDetail.observe(this, Observer {
            loadMovieDetail(it)
        })             //loadCastRecyclerView(it)
    }

    private fun loadMovieDetail(it: MovieDetail?) {
        binding.rvMovieGenres.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false)
        //binding.rvMovieGenres.adapter = it?.let { MovieDetailGenreAdapter(it.genres) }
        binding.rvMovieGenres.adapter = it?.let { it.genres?.let { genre -> MovieDetailGenreAdapter(genre) } }

        binding.rvCast.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false)
        binding.rvCast.adapter = it?.let { it.credits?.let { cast -> MovieDetailCastAdapter(cast) } }

    }


}