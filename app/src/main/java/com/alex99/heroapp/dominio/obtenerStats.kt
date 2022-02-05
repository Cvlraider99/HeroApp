package com.alex99.heroapp.dominio

import com.alex99.heroapp.data.StatsRepositorio
import com.alex99.heroapp.data.modelos.PowerStats

class obtenerStats(val id:String){

    private val repositorio = StatsRepositorio()

    suspend operator fun invoke():PowerStats = repositorio.getAllStats(id)
}