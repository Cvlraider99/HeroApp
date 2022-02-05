package com.alex99.heroapp.data.modelos

import com.google.gson.annotations.SerializedName

data class Biografia (
    @SerializedName("response") var response: String,
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String,
    @SerializedName("full-name") var fullName: String,
    @SerializedName("alter-egos") var alterEgos: String,
    @SerializedName("aliases") var aliases: List<String>,
    @SerializedName("place-of-birth") var placeBirth: String,
    @SerializedName("first-appearance") var firstAppearence: String,
    @SerializedName("publisher") var publisher: String,
    @SerializedName("alignment") var alignment: String
)