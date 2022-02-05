package com.alex99.heroapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdaptadorHeroe (val name:List<String>, val imagen:List<String>, val id:List<String>):RecyclerView.Adapter<HeroeViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroeViewHolder(layoutInflater.inflate(R.layout.item_hero,parent,false))
    }

    override fun onBindViewHolder(holder: HeroeViewHolder, position: Int) {
        val nombre: String = name[position]
        val imagen : String = imagen[position]
        val id: String = id[position]

        holder.bind(nombre,imagen,id)
    }

    override fun getItemCount(): Int =  name.size

}