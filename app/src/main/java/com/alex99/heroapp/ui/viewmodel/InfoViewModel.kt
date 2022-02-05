package com.alex99.heroapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex99.heroapp.data.modelos.PowerStats
import com.alex99.heroapp.dominio.obtenerStats
import kotlinx.coroutines.launch

private const val TAG = "PruebaViewModel"

class InfoViewModel: ViewModel(){

    val statsModel = MutableLiveData<PowerStats>()


    fun onCreate(id:String){
        Log.d(TAG,"Se entra al on create")
        viewModelScope.launch {
            val result = obtenerStats(id)()
            Log.d(TAG,"Regresa ${result.intelligence}")
            statsModel.postValue(result)
        }
    }


}