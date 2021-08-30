package com.schratzenstaller.wilcilene.mynewmovieinfo.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.schratzenstaller.wilcilene.mynewmovieinfo.databinding.FragmentMovieBinding
import com.schratzenstaller.wilcilene.mynewmovieinfo.domain.Genre
import com.schratzenstaller.wilcilene.mynewmovieinfo.domain.Movie
import com.schratzenstaller.wilcilene.mynewmovieinfo.view.adapter.MovieAdapter
import com.schratzenstaller.wilcilene.mynewmovieinfo.view.adapter.MovieGenreAdapter
import com.schratzenstaller.wilcilene.mynewmovieinfo.viewmodel.GenreViewModel
import com.schratzenstaller.wilcilene.mynewmovieinfo.viewmodel.GenreViewModelFactory
import com.schratzenstaller.wilcilene.mynewmovieinfo.viewmodel.MovieViewModel
import com.schratzenstaller.wilcilene.mynewmovieinfo.viewmodel.MovieViewModelFactory

class MovieFragment : Fragment(), MovieAdapter.OnItemClickListener {
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieViewModel =
            ViewModelProvider(this, MovieViewModelFactory())
                .get(MovieViewModel::class.java)
        movieViewModel.movies.observe(viewLifecycleOwner, Observer {
            setupMovieRecyclerView(it)
        })

        val genreViewModel =
            ViewModelProvider(this, GenreViewModelFactory())
                .get(GenreViewModel::class.java)
        genreViewModel.genres.observe(viewLifecycleOwner, Observer {
            setupGenreRecyclerView(it)
        })
    }

    private fun setupMovieRecyclerView(movies: List<Movie?>) {
        binding.rvMovies.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false)

        binding.rvMovies.adapter = movies.let {MovieAdapter(movies, this@MovieFragment)}
    }

    private fun setupGenreRecyclerView(genres: List<Genre?>?) {
        binding.rvGenres.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false)

        binding.rvGenres.adapter = genres?.let { MovieGenreAdapter(it) }
    }

    override fun onClick(movie: Movie) {
        val intent = Intent(this.context, MovieDetailActivity::class.java)
        intent.putExtra("MOVIE_ID", movie.id.toString())
        startActivity(intent)
    }
}