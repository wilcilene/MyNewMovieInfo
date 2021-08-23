package com.schratzenstaller.wilcilene.mynewmovieinfo.viewmodel


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.schratzenstaller.wilcilene.mynewmovieinfo.api.Repository
import com.schratzenstaller.wilcilene.mynewmovieinfo.domain.*

class MovieDetailViewModel : ViewModel()  {
    var movieDetail = MutableLiveData<MovieDetail?>()
//    var movieDetail = MutableLiveData<MovieDetail?>()

    init {
        Thread(Runnable {
            loadMovies()
        }).start()
    }

    private fun loadMovies() {
        val movieDetailApiResult = Repository.getMovieDetail(451048)

        var genres = mutableListOf<Genre>()
        var credits = mutableListOf<Cast>()

        movieDetailApiResult?.genres?.forEach {
            val newGenres = Genre(
                it.id,
                it.name
            )
            genres.add(newGenres)
        }

        movieDetailApiResult?.credits?.forEach {
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
            null
        )


        movieDetail.postValue(newMovieDetail)
    }
}