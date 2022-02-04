//configuracion de Retrofit
package com.alex99.heroapp.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitHelper {
    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://www.superheroapi.com/api.php/4961175993942043/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}