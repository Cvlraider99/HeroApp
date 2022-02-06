package com.alex99.heroapp.data

import com.alex99.heroapp.data.modelos.ApaProvaider
import com.alex99.heroapp.data.modelos.Apariencia
import com.alex99.heroapp.data.network.APIService

class ApaRepositorio {
    private val api = APIService()

    suspend fun getInfoApa(id:String): Apariencia {
        val response : Apariencia = api.obtenerApa(id)
        ApaProvaider.apariencia = response
        return response
    }
}