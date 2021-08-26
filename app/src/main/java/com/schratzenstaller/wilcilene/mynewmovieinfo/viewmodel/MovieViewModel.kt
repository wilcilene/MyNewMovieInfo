package com.schratzenstaller.wilcilene.mynewmovieinfo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.schratzenstaller.wilcilene.mynewmovieinfo.api.Repository
import com.schratzenstaller.wilcilene.mynewmovieinfo.domain.Movie

class MovieViewModel : ViewModel() {

    var movies = MutableLiveData<List<Movie?>>()

    init {
        Thread(Runnable {
            loadMovies()
        }).start()
    }

    private fun loadMovies() {
        val movieListApiResult = Repository.getAllMovies()
        val movieList = mutableListOf<Movie>()

        val list = movieListApiResult?.results

        list?.forEach {
            //Log.d("MovieViewModel", it.toString())
            val newMovie = Movie(
                it.id,
                it.poster_path,
                it.title,
                it.vote_average
            )
            movieList.add(newMovie)
        }
        movies.postValue(movieList)
    }
}