package com.alex99.heroapp.data.network

import com.alex99.heroapp.data.modelos.Biografia
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIBio {
    @GET
    suspend fun obtenerBio(@Url url:String): Response<Biografia>
}