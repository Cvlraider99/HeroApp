//Este es mi API service
package com.alex99.heroapp.data.network

import com.alex99.heroapp.data.modelos.ListaHeroes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APILlamada {
    @GET
    suspend fun obtenerListaHeroes(@Url url:String): Response<ListaHeroes>
}