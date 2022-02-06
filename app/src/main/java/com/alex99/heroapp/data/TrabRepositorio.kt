package com.alex99.heroapp.data

import com.alex99.heroapp.data.modelos.TrabProvaider
import com.alex99.heroapp.data.modelos.Trabajo
import com.alex99.heroapp.data.network.APIService

class TrabRepositorio {
    private val api = APIService()

    suspend fun getInfoTrab(id:String): Trabajo {
        val response : Trabajo = api.obtenerTrab(id)
        TrabProvaider.trabajo = response
        return response
    }
}