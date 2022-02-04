package com.alex99.heroapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdaptadorHeroe (val name:List<String>, val imagen:List<String>):RecyclerView.Adapter<HeroeViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroeViewHolder(layoutInflater.inflate(R.layout.item_hero,parent,false))
    }

    override fun onBindViewHolder(holder: HeroeViewHolder, position: Int) {
        val nombre: String = name[position]
        val imagen : String = imagen[position]

        holder.bind(nombre,imagen)
    }

    override fun getItemCount(): Int =  name.size

}