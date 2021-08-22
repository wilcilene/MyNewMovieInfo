package com.schratzenstaller.wilcilene.mynewmovieinfo.view

import android.os.Bundle
import android.util.Log
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


class MovieFragment : Fragment(){

    companion object {
        fun newInstance() = MovieFragment()
        val TAG = "MovieFragment"
    }
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!

//    private lateinit var movieViewModel: MovieViewModel
//    private val movieViewModel =
//        ViewModelProvider(requireActivity(), MovieViewModelFactory())
//            .get(MovieViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var movieViewModel =
            ViewModelProvider(this, MovieViewModelFactory())
                .get(MovieViewModel::class.java)
        movieViewModel.movies.observe(viewLifecycleOwner, Observer {
            loadMovieRecyclerView(it)
        })

        var genreViewModel =
            ViewModelProvider(this, GenreViewModelFactory())
                .get(GenreViewModel::class.java)
        genreViewModel.genres.observe(viewLifecycleOwner, Observer {
            loadGenreRecyclerView(it)
        })
    }

    private fun loadMovieRecyclerView(movies: List<Movie?>) {
        Log.e(TAG, "passou no loadRecycler${movies.toString()}")

        binding.rvMovies.layoutManager = LinearLayoutManager(
                context,
        LinearLayoutManager.HORIZONTAL,
        false)
        binding.rvMovies.adapter = movies?.let { MovieAdapter(movies) }
        Log.d(
            TAG,
            "$movies.id"
        )
    }

    private fun loadGenreRecyclerView(genres:List<Genre?>?) {
        binding.rvGenres.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false)
        binding.rvGenres.adapter = genres?.let { MovieGenreAdapter(genres) }
    }

//    override fun onClick(idMovie: String?) {
//        val intent = Intent(this.context, MovieDetailActivity::class.java)
//        intent.putExtra("IDMOVIE", idMovie)
//        startActivity(intent)
//    }


}