package com.alex99.heroapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex99.heroapp.data.modelos.Biografia
import com.alex99.heroapp.dominio.ObtenerBio
import kotlinx.coroutines.launch

private const val TAG = "PruebaViewModelBio"

class BioViewModel: ViewModel() {
    val bioModel = MutableLiveData<Biografia>()


    fun onCreate(id:String){
        viewModelScope.launch {
            val result = ObtenerBio(id)()
            Log.d(TAG,"Regresa ${result.fullName}")
            bioModel.postValue(result)
        }
    }

}