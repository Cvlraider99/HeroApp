package com.alex99.heroapp.data.modelos

import com.google.gson.annotations.SerializedName

data class Conexiones(
    @SerializedName("response") var response: String,
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String,
    @SerializedName("group-affiliation") var groupAffiliation: String,
    @SerializedName("relatives") var relatives: String,
)
