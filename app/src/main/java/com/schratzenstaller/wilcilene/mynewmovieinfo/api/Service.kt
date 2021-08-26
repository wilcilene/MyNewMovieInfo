package com.schratzenstaller.wilcilene.mynewmovieinfo.api

import com.schratzenstaller.wilcilene.mynewmovieinfo.api.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {

    @GET("3/movie/popular")
    fun getAllMovies(
                    @Query("api_key") api_key: String,
                    @Query("page") page:Int,
                    @Query("language") languageString: String = "pt-BR"
    ): Call<MovieListApiResult>

    @GET("/3/genre/movie/list")
    fun getAllGenres(
        @Query("api_key") api_key: String,
        @Query("language") languageString: String = "pt-BR"
    ): Call<GenreListApiResult>

    @GET("3/movie/{idMovie}")
    fun getMovieDetail(@Path("idMovie") idMovie: String,
                       @Query("api_key") api_key: String,
                       @Query("language") languageString: String = "pt-BR",
                       @Query("append_to_response") append_to_response: String = "credits,release_dates"
    ): Call<MovieDetailApiResult>

}
