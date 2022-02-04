package com.alex99.heroapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.alex99.heroapp.data.modelos.ListaHeroes
import com.alex99.heroapp.data.network.APILlamada
import com.alex99.heroapp.data.network.APIService
import com.alex99.heroapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AdaptadorHeroe
    private val nombres = mutableListOf<String>()
    private val imagenes = mutableListOf<String>()

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
        adapter = AdaptadorHeroe(nombres,imagenes)
        binding.rvHeroes.layoutManager = LinearLayoutManager(this)
        binding.rvHeroes.adapter = adapter
    }


    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://www.superheroapi.com/api.php/4961175993942043/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
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
                    if (nameHeroe != null) {
                        nombres.add(nameHeroe)
                    }
                    if (imageHero != null) {
                        imagenes.add(imageHero)
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