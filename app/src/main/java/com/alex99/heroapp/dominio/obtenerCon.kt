package com.alex99.heroapp.dominio

import com.alex99.heroapp.data.ConRepositorio
import com.alex99.heroapp.data.modelos.Conexiones

class ObtenerCon(val id:String) {
    private val repositorio = ConRepositorio()

    suspend operator fun invoke(): Conexiones = repositorio.getInfoCon(id)
}