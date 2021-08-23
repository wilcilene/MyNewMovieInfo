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
                    @Query("page") page:Int
    ): Call<MovieListApiResult>

    @GET("/3/genre/movie/list")
    fun getAllGenres(
        @Query("api_key") api_key: String,
        //, @Query("language") languageString: String = "pt-BR"
        //https://api.themoviedb.org/3/genre/movie/list?api_key=ae93539e5e6476feaacec7675254f488&language=pt-BR
    ): Call<GenreListApiResult>

    //@GET("3/movie/{idMovie}")
    @GET("3/movie/{idMovie}")
    fun getMovieDetail(@Path("idMovie") idMovie: Int,
                       @Query("api_key") api_key: String,
                       @Query("append_to_response") append_to_response: String = "credits,release_dates"
    ): Call<MovieDetailApiResult>


//    @GET("3/movie/{idMovie}")
//    fun getMovieDetail(@Path("idMovie") idMovie: Int,
//                       @Query("api_key") api_key: String,
//    ): Call<MovieDetailApiResult>
}
