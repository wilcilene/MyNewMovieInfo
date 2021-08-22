package com.schratzenstaller.wilcilene.mynewmovieinfo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.schratzenstaller.wilcilene.mynewmovieinfo.api.Repository
import com.schratzenstaller.wilcilene.mynewmovieinfo.domain.*

class MovieDetailViewModel : ViewModel() {
    //var movies = MutableLiveData<List<MovieDetail?>>()
    var movieDetail = MutableLiveData<MovieDetail?>()

    init {
        Thread(Runnable {
            loadMovies()
        }).start()
    }

    private fun loadMovies() {
        val movieDetailApiResult = Repository.getMovieDetail(451048)
        //var movieDetail = mutableListOf<MovieDetail>()
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
            //it.cast?.forEach{
            val newCast = Cast(
                it.profile_path,
                it.name,
                it.character
            )
            credits.add(newCast)
        }

        val newMovieDetail = MovieDetail(
            id = movieDetailApiResult?.id,
            backdrop_path = movieDetailApiResult?.backdrop_path,
            vote_average = movieDetailApiResult?.vote_average,
            title = movieDetailApiResult?.title,
            release_date = movieDetailApiResult?.release_date,
            runtime = movieDetailApiResult?.runtime,
            genres = genres,
            overview = movieDetailApiResult?.overview,
            credits = credits
        )

        //movieDetailList.add(newMovieDetail)

        movieDetail.postValue(newMovieDetail)
    }
}