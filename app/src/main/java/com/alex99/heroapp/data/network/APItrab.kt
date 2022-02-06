package com.alex99.heroapp.data.network

import com.alex99.heroapp.data.modelos.Trabajo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APItrab {
    @GET
    suspend fun obtenerTrab(@Url url:String): Response<Trabajo>
}