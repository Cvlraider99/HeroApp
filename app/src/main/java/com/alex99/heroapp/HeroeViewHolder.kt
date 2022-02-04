package com.alex99.heroapp

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

import androidx.recyclerview.widget.RecyclerView
import com.alex99.heroapp.databinding.ItemHeroBinding
import com.alex99.heroapp.mostrarInfo.DesplegarInfo
import com.squareup.picasso.Picasso

class HeroeViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {

    private lateinit var nombre:String

    init{
        itemView.setOnClickListener (this)
    }

    private val binding = ItemHeroBinding.bind(view)

    fun bind(name:String, image:String){
        this.nombre = name
        Picasso.get().load(image).into(binding.imageHero)
        binding.nombreHeroe.text = name
    }

    override fun onClick(p0: View?) {
        val context = itemView.context
        Toast.makeText(context,"Seleccionaste a $nombre ", Toast.LENGTH_SHORT).show()
        val intent = DesplegarInfo.nuevoIntent(context,nombre)
        context.startActivity(intent)
    }
}
