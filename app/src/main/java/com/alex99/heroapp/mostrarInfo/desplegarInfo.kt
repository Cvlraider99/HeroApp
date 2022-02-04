package com.alex99.heroapp.mostrarInfo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alex99.heroapp.R

class DesplegarInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.desplegar_info)

        //val campoDeEdicion = findViewById<EditText>(R.id.campoDeEdicion)
        //val textoAEditar = intent.getStringExtra("STRING_ANTERIOR")
        //campoDeEdicion.setText(textoAEditar)
    }

    @Suppress("UNUSED_PARAMETER")
    fun ok(unBoton: View){
        //val nuevoString = findViewById<EditText>(R.id.campoDeEdicion).text.toString()

        /*if(nuevoString.isEmpty()){
            Toast.makeText(this,"El campo no puede quedar vacio", Toast.LENGTH_SHORT)
            return
        }*/
    }
    companion object{
        fun nuevoIntent(contexto: Context, stringNombre: String) : Intent {
            return Intent(contexto, DesplegarInfo::class.java).apply {
                putExtra("STRING_ANTERIOR",stringNombre)
            }
        }
    }
}