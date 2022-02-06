package com.alex99.heroapp.data.network

import com.alex99.heroapp.data.modelos.Apariencia
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIApa {
    @GET
    suspend fun obtenerApa(@Url url:String): Response<Apariencia>
}