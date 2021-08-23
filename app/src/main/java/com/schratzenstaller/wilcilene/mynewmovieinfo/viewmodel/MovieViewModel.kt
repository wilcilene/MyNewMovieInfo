package com.schratzenstaller.wilcilene.mynewmovieinfo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.schratzenstaller.wilcilene.mynewmovieinfo.api.Repository
import com.schratzenstaller.wilcilene.mynewmovieinfo.domain.*

class MovieViewModel : ViewModel() {
    //var movies = MutableLiveData<List<MovieDetail?>>()
    var movies = MutableLiveData<List<Movie?>>()

    init {
        Thread(Runnable {
            loadMovies()
        }).start()
    }

    private fun loadMovies() {
        val movieListApiResult = Repository.getAllMovies()
        var movieList = mutableListOf<Movie>()

        var list = movieListApiResult?.results

        list?.forEach {
            Log.e("MovieViewModel", it.toString())
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