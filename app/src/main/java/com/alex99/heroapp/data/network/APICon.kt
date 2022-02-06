package com.alex99.heroapp.data.network

import com.alex99.heroapp.data.modelos.Conexiones
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APICon {
    @GET
    suspend fun obtenerCon(@Url url:String): Response<Conexiones>
}