package com.alex99.heroapp.data.modelos

import com.google.gson.annotations.SerializedName

data class Trabajo(
    @SerializedName("response") var response: String,
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String,
    @SerializedName("occupation") var occupation: String,
    @SerializedName("base") var base: String
)
