package com.example.flickrbrowserappretrofit

data class Photo(
    val farm: Int,
    val height_t: Int,
    val id: String,
    val isfamily: Int,
    val isfriend: Int,
    val ispublic: Int,
    val owner: String,
    val secret: String,
    val server: String,
    val title: String,
    val url_t: String,
    val width_t: Int
)