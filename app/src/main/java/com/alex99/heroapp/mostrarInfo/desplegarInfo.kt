package com.alex99.heroapp.mostrarInfo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alex99.heroapp.R
import com.alex99.heroapp.ui.viewmodel.InfoViewModel


private const val TAG = "desplegarInfo"

class DesplegarInfo : AppCompatActivity() {


    private val statsViewModel:InfoViewModel by lazy {
        ViewModelProvider (this).get(InfoViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"Se inicia la actividad")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.desplegar_info)

        val labelInteligencia = findViewById<TextView>(R.id.campoInteligencia)
        val labelFuerza = findViewById<TextView>(R.id.campoFuerza)
        val labelVelocidad = findViewById<TextView>(R.id.campoVelocidad)
        val labelDurabilidad = findViewById<TextView>(R.id.campoDurabilidad)
        val labelPoder = findViewById<TextView>(R.id.campoPoder)
        val labelCombate = findViewById<TextView>(R.id.campoCombate)


        val idPersonaje = intent.getStringExtra("STRING_ANTERIOR")
        statsViewModel.onCreate(idPersonaje.toString())


        statsViewModel.statsModel.observe(this, {
            labelInteligencia.text = it.id
            labelFuerza.text = it.strength
            labelVelocidad.text = it.speed
            labelDurabilidad.text = it.durability
            labelPoder.text = it.power
            labelCombate.text = it.combat
        })
    }

    companion object{
        fun nuevoIntent(contexto: Context, stringID: String) : Intent {
            return Intent(contexto, DesplegarInfo::class.java).apply {
                putExtra("STRING_ANTERIOR",stringID)
            }
        }
    }
}