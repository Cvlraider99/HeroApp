package com.alex99.heroapp.data.network

import com.alex99.heroapp.core.RetroFitHelper.getRetrofit
import com.alex99.heroapp.data.modelos.Apariencia
import com.alex99.heroapp.data.modelos.Biografia
import com.alex99.heroapp.data.modelos.ListaHeroes
import com.alex99.heroapp.data.modelos.PowerStats
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class APIService {
    private val retrofit = getRetrofit()

    suspend fun obtenerStats(id:String):PowerStats{

        return withContext (Dispatchers.IO){
            val response :Response<PowerStats>  = retrofit.create(APIPowerstats::class.java).obtenerPowerstats("$id/powerstats")
            response.body()!!
        }
    }

    suspend fun obtenerBio(id:String):Biografia{

        return withContext (Dispatchers.IO){
            val response :Response<Biografia>  = retrofit.create(APIBio::class.java).obtenerBio("$id/biography")
            response.body()!!
        }
    }

    suspend fun obtenerApa(id:String):Apariencia{

        return withContext (Dispatchers.IO){
            val response :Response<Apariencia>  = retrofit.create(APIApa::class.java).obtenerApa("$id/appearance")
            response.body()!!
        }
    }

    suspend fun obtenerListaHeroes(id: String): Response<ListaHeroes> {
        return getRetrofit().create(APILlamada::class.java).obtenerListaHeroes("$id/image")
    }


}