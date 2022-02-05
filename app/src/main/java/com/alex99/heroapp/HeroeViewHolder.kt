package com.alex99.heroapp

import android.view.View


import androidx.recyclerview.widget.RecyclerView
import com.alex99.heroapp.databinding.ItemHeroBinding
import com.alex99.heroapp.mostrarInfo.DesplegarInfo
import com.squareup.picasso.Picasso

class HeroeViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {

    private lateinit var id:String

    init{
        itemView.setOnClickListener (this)
    }

    private val binding = ItemHeroBinding.bind(view)

    fun bind(name:String, image:String, id:String){
        this.id = id
        Picasso.get().load(image).into(binding.imageHero)
        binding.nombreHeroe.text = name
    }

    override fun onClick(p0: View?) {
        val context = itemView.context
        //Toast.makeText(context,"Seleccionaste a $id ", Toast.LENGTH_SHORT).show()
        val intent = DesplegarInfo.nuevoIntent(context,id)
        context.startActivity(intent)
    }
}
