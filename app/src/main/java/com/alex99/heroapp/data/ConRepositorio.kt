package com.alex99.heroapp.data

import com.alex99.heroapp.data.modelos.ConProvaider
import com.alex99.heroapp.data.modelos.Conexiones
import com.alex99.heroapp.data.network.APIService

class ConRepositorio {
    private val api = APIService()

    suspend fun getInfoCon(id:String): Conexiones {
        val response : Conexiones = api.obtenerCon(id)
        ConProvaider.conexiones = response
        return response
    }
}