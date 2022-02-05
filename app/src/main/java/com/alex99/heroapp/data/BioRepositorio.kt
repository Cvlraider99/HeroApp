package com.alex99.heroapp.data

import com.alex99.heroapp.data.modelos.*
import com.alex99.heroapp.data.network.APIService

class BioRepositorio {
    private val api = APIService()

    suspend fun getInfoBio(id:String): Biografia {
        val response : Biografia = api.obtenerBio(id)
        BioProvaider.biografia = response
        return response
    }
}