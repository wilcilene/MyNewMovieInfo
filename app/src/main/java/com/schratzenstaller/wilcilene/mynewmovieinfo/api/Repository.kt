package com.schratzenstaller.wilcilene.mynewmovieinfo.api

import com.schratzenstaller.wilcilene.mynewmovieinfo.api.model.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Repository {
    private val service: Service
    private const val API_KEY: String = "ae93539e5e6476feaacec7675254f488"

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(Service::class.java)
    }

    fun getAllMovies(): MovieListApiResult? {
        //ALTERNAR AS PAGINAS de 1 a 500total_pages
        var page = 1
        val callMovies = service.getAllMovies(API_KEY, page)

        return callMovies.execute().body()
    }

    fun getAllGenres(): GenreListApiResult?{
        val callGenres = service.getAllGenres(API_KEY)

        return callGenres.execute().body()
    }

    fun getMovieDetail(idMovie: Int?): MovieDetailApiResult? {
        val callMovieDetail = idMovie?.let { service.getMovieDetail(it?.toInt(), API_KEY) }

        return callMovieDetail?.execute()?.body()
    }
}