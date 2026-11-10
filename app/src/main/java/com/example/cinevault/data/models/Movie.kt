package com.example.cinevault.data.models


data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String,
    val cast: List<Cast> = emptyList()
)