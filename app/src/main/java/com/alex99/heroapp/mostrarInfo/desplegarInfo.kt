package com.alex99.heroapp.mostrarInfo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alex99.heroapp.R
import com.alex99.heroapp.ui.viewmodel.BioViewModel
import com.alex99.heroapp.ui.viewmodel.InfoViewModel


private const val TAG = "desplegarInfo"

class DesplegarInfo : AppCompatActivity() {


    private val statsViewModel:InfoViewModel by lazy {
        ViewModelProvider (this).get(InfoViewModel::class.java)
    }

    private val bioViewModel:BioViewModel by lazy {
        ViewModelProvider (this).get(BioViewModel::class.java)
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
        val labelNomCom = findViewById<TextView>(R.id.campoNombreCompleto)
        val labelNacimiento = findViewById<TextView>(R.id.campoNacimiento)
        val labelAparicion = findViewById<TextView>(R.id.campoPrimera)
        val labelPublisher = findViewById<TextView>(R.id.campoPublisher)
        val labelAligment = findViewById<TextView>(R.id.campoAligment)


        val idPersonaje = intent.getStringExtra("STRING_ANTERIOR")
        statsViewModel.onCreate(idPersonaje.toString())
        bioViewModel.onCreate(idPersonaje.toString())


        statsViewModel.statsModel.observe(this, {
            labelInteligencia.text = it.id
            labelFuerza.text = it.strength
            labelVelocidad.text = it.speed
            labelDurabilidad.text = it.durability
            labelPoder.text = it.power
            labelCombate.text = it.combat
        })

        bioViewModel.bioModel.observe(this, {
            labelNomCom.text = it.fullName
            labelNacimiento.text = it.placeBirth
            labelAparicion.text = it.firstAppearence
            labelPublisher.text = it.publisher
            labelAligment.text = it.alignment
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