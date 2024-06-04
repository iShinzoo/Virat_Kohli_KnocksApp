package com.example.promptmotion.data

import retrofit2.http.GET

interface ImageApi{

    @GET("/randomImage")
    suspend fun getRandomImage(): Image


    companion object{
        const val BASE_URL = "http://192.168.43.91:8100"

    }
}