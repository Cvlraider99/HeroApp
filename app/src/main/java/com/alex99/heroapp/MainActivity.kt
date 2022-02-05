package com.alex99.heroapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.alex99.heroapp.data.network.APIService
import com.alex99.heroapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AdaptadorHeroe
    private val nombres = mutableListOf<String>()
    private val imagenes = mutableListOf<String>()
    private val id = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        for (i in 1..200)
        {
            obtenerLista(i.toString())
        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = AdaptadorHeroe(nombres,imagenes,id)
        binding.rvHeroes.layoutManager = LinearLayoutManager(this)
        binding.rvHeroes.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun obtenerLista(query : String){
        CoroutineScope(Dispatchers.IO).launch {
            val conexion = APIService()
            val call = conexion.obtenerListaHeroes(query)
            val todosHeroes=call.body()
            runOnUiThread{
                if (call.isSuccessful)
                {
                    val nameHeroe = todosHeroes?.name
                    val imageHero = todosHeroes?.image
                    val idHero = todosHeroes?.id
                    if (nameHeroe != null) {
                        nombres.add(nameHeroe)
                    }
                    if (imageHero != null) {
                        imagenes.add(imageHero)
                    }
                    if (idHero != null) {
                        id.add(idHero)
                    }
                    adapter.notifyDataSetChanged()
                }
                else {
                    showError()
                }
            }
        }
    }

    private fun showError(){
        Toast.makeText(this,"Lo siento no se pudo cargar la información", Toast.LENGTH_SHORT).show()
    }

}