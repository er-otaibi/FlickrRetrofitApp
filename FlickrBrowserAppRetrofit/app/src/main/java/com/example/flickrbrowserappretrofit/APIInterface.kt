package com.example.flickrbrowserappretrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface APIInterface {

    @Headers("Content-Type: application/json")
    @GET("/services/rest/?method=flickr.photos.search&api_key=82c22bad9d298cbfe97e7ec9a30bd942&format=json&nojsoncallback=1&extras=url_t")
    fun getPhoto(@Query("text") tag: String): Call<Photos>

}