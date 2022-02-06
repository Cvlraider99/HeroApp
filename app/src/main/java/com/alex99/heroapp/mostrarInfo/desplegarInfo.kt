package com.alex99.heroapp.mostrarInfo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alex99.heroapp.R
import com.alex99.heroapp.ui.viewmodel.ApaViewModel
import com.alex99.heroapp.ui.viewmodel.BioViewModel
import com.alex99.heroapp.ui.viewmodel.InfoViewModel
import com.alex99.heroapp.ui.viewmodel.TrabViewModel


private const val TAG = "desplegarInfo"

class DesplegarInfo : AppCompatActivity() {


    private val statsViewModel:InfoViewModel by lazy {
        ViewModelProvider (this).get(InfoViewModel::class.java)
    }

    private val bioViewModel:BioViewModel by lazy {
        ViewModelProvider (this).get(BioViewModel::class.java)
    }

    private val apaViewModel:ApaViewModel by lazy {
        ViewModelProvider (this).get(ApaViewModel::class.java)
    }

    private val trabViewModel:TrabViewModel by lazy {
        ViewModelProvider (this).get(TrabViewModel::class.java)
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
        val labelGenero = findViewById<TextView>(R.id.campoGenero)
        val labelAltura = findViewById<TextView>(R.id.campoAltura)
        val labelPeso = findViewById<TextView>(R.id.campoPeso)
        val labelOjos = findViewById<TextView>(R.id.campoOjos)
        val labelPelo = findViewById<TextView>(R.id.campoPelo)
        val labelRaza = findViewById<TextView>(R.id.campoRaza)
        val labelOcupacion = findViewById<TextView>(R.id.campoOcupacion)
        val labelBase = findViewById<TextView>(R.id.campoBase)


        val idPersonaje = intent.getStringExtra("STRING_ANTERIOR")
        statsViewModel.onCreate(idPersonaje.toString())
        bioViewModel.onCreate(idPersonaje.toString())
        apaViewModel.onCreate(idPersonaje.toString())
        trabViewModel.onCreate(idPersonaje.toString())

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

        apaViewModel.apaModel.observe(this, {
            labelGenero.text = it.gender
            labelAltura.text = it.height[1]
            labelPeso.text = it.weight[1]
            labelOjos.text = it.eyeColor
            labelPelo.text = it.hairColor
            labelRaza.text = it.race
        })

        trabViewModel.trabModel.observe(this, {
            labelOcupacion.text = it.occupation
            labelBase.text = it.base
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