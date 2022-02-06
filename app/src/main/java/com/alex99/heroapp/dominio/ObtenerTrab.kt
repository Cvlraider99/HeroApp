package com.alex99.heroapp.dominio


import com.alex99.heroapp.data.TrabRepositorio
import com.alex99.heroapp.data.modelos.Trabajo

class ObtenerTrab(val id:String) {
    private val repositorio = TrabRepositorio()

    suspend operator fun invoke(): Trabajo = repositorio.getInfoTrab(id)
}