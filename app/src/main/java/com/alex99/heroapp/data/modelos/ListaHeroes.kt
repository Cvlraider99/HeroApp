package com.alex99.heroapp.data.modelos

import com.google.gson.annotations.SerializedName

data class ListaHeroes (
    @SerializedName("response") var response: String,
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String,
    @SerializedName("url") var image: String,

)
