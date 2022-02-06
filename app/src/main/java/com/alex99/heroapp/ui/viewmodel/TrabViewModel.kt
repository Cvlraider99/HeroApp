package com.alex99.heroapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex99.heroapp.data.modelos.Trabajo
import com.alex99.heroapp.dominio.ObtenerTrab
import kotlinx.coroutines.launch

private const val TAG = "PruebaViewModelBio"

class TrabViewModel: ViewModel()  {
    val trabModel = MutableLiveData<Trabajo>()


    fun onCreate(id:String){
        viewModelScope.launch {
            val result = ObtenerTrab(id)()
            Log.d(TAG,"Regresa en trabajo ${result.base}")
            trabModel.postValue(result)
        }
    }
}