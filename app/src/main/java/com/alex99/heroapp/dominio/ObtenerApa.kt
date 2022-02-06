package com.alex99.heroapp.dominio

import com.alex99.heroapp.data.ApaRepositorio
import com.alex99.heroapp.data.modelos.Apariencia

class ObtenerApa(val id:String) {
    private val repositorio = ApaRepositorio()

    suspend operator fun invoke(): Apariencia = repositorio.getInfoApa(id)
}