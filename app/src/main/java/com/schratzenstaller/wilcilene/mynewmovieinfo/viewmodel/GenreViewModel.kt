package com.schratzenstaller.wilcilene.mynewmovieinfo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.schratzenstaller.wilcilene.mynewmovieinfo.api.Repository
import com.schratzenstaller.wilcilene.mynewmovieinfo.domain.Genre

class GenreViewModel: ViewModel() {
    var genres = MutableLiveData<List<Genre?>>()

    init {
        Thread(Runnable {
            loadGenres()
        }).start()
    }

    private fun loadGenres() {
        val genreListApiResult = Repository.getAllGenres()
        val genreList = mutableListOf<Genre>()

        val list = genreListApiResult?.genres

        list?.forEach {
            val newGenre = Genre(
                it.id,
                it.name
            )

            genreList.add(newGenre)
        }

        genres.postValue(genreList)

    }
}