package com.alex99.heroapp.dominio

import com.alex99.heroapp.data.BioRepositorio
import com.alex99.heroapp.data.modelos.Biografia

class ObtenerBio(val id:String) {

    private val repositorio = BioRepositorio()

    suspend operator fun invoke(): Biografia = repositorio.getInfoBio(id)

}