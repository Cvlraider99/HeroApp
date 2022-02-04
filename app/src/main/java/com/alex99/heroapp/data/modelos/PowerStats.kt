package com.alex99.heroapp.data.modelos

import com.google.gson.annotations.SerializedName

data class PowerStats(
    @SerializedName("response") var response: String,
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String,
    @SerializedName("intelligence") var intelligence: String,
    @SerializedName("strength") var strength: String,
    @SerializedName("speed") var speed: String,
    @SerializedName("durability") var durability: String,
    @SerializedName("power") var power: String,
    @SerializedName("combat") var combat: String,
)
