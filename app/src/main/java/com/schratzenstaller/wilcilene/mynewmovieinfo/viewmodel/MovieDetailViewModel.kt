package com.schratzenstaller.wilcilene.mynewmovieinfo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.schratzenstaller.wilcilene.mynewmovieinfo.api.Repository
import com.schratzenstaller.wilcilene.mynewmovieinfo.domain.*

class MovieDetailViewModel(idMovie: String) : ViewModel()  {
    var movieDetail = MutableLiveData<MovieDetail?>()
    var idMovieDetail = idMovie

    init {
        Thread(Runnable {
            loadMovies()
        }).start()
    }

    private fun loadMovies() {
        val movieDetailApiResult = Repository.getMovieDetail(idMovieDetail)

        val genres = mutableListOf<Genre>()
        val credits = mutableListOf<Cast>()

        movieDetailApiResult?.genres?.forEach {
            val newGenres = Genre(
                it.id,
                it.name
            )
            genres.add(newGenres)
        }

        movieDetailApiResult?.credits?.cast?.forEach() {
            val newCast = Cast(
                it.profile_path,
                it.name,
                it.character
            )
            credits.add(newCast)
        }

        val newMovieDetail = MovieDetail(
            movieDetailApiResult?.id,
            movieDetailApiResult?.backdrop_path,
            movieDetailApiResult?.vote_average,
            movieDetailApiResult?.title,
            movieDetailApiResult?.release_date,
            movieDetailApiResult?.runtime,
            genres,
            movieDetailApiResult?.overview,
            credits
        )
        movieDetail.postValue(newMovieDetail)
    }
}