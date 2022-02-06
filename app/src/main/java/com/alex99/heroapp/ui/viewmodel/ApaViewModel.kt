package com.alex99.heroapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex99.heroapp.data.modelos.Apariencia
import com.alex99.heroapp.dominio.ObtenerApa
import kotlinx.coroutines.launch

private const val TAG = "PruebaViewModelBio"

class ApaViewModel: ViewModel()  {
    val apaModel = MutableLiveData<Apariencia>()


    fun onCreate(id:String){
        viewModelScope.launch {
            val result = ObtenerApa(id)()
            Log.d(TAG,"Regresa ${result.race}")
            apaModel.postValue(result)
        }
    }
}