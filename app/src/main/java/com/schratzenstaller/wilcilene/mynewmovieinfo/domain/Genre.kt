package com.schratzenstaller.wilcilene.mynewmovieinfo.domain

data class ListGenre(
    val genres: List<Genre>?
)

data class Genre(
    val id: String?,
    val name: String?
)
