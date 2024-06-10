package com.example.messengerapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/messages/")
    fun getMessages(): Call<List<Message>>
}
