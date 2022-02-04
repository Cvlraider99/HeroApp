package com.alex99.heroapp.data.network

import com.alex99.heroapp.core.RetroFitHelper
import com.alex99.heroapp.core.RetroFitHelper.getRetrofit
import com.alex99.heroapp.data.modelos.ListaHeroes
import com.alex99.heroapp.data.modelos.PowerStats
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class APIService {
    private val retrofit = RetroFitHelper.getRetrofit()

    suspend fun obtenerStats(id:String):List<PowerStats>{
        return withContext (Dispatchers.IO){
            val response: Response<List<PowerStats>> = retrofit.create(APIPowerstats::class.java).obtenerPowerstats("$id/image")
            response.body() ?: emptyList()
        }
    }

    suspend fun obtenerListaHeroes(id: String): Response<ListaHeroes> {
        return getRetrofit().create(APILlamada::class.java).obtenerListaHeroes("$id/image")
    }


}