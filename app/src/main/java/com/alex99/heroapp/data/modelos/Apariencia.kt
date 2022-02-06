package com.alex99.heroapp.data.modelos

import com.google.gson.annotations.SerializedName

data class Apariencia(
    @SerializedName("response") var response: String,
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String,
    @SerializedName("gender") var gender: String,
    @SerializedName("race") var race: String,
    @SerializedName("height") var height: List<String>,
    @SerializedName("weight") var weight: List<String>,
    @SerializedName("eye-color") var eyeColor: String,
    @SerializedName("hair-color") var hairColor: String,
)
