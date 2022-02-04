package com.alex99.heroapp.data.network

import com.alex99.heroapp.data.modelos.PowerStats
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIPowerstats {
    @GET
    suspend fun obtenerPowerstats(@Url url:String): Response<List<PowerStats>>
}