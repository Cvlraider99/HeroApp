package com.alex99.heroapp.data

import com.alex99.heroapp.data.modelos.PowerStats
import com.alex99.heroapp.data.modelos.StatsProvaider
import com.alex99.heroapp.data.network.APIService

class StatsRepositorio {

    private val api = APIService()

    suspend fun getAllStats(id:String):PowerStats{
        val response : PowerStats = api.obtenerStats(id)
        StatsProvaider.stats = response
        return response
    }
}