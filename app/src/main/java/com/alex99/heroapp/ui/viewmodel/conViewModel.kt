package com.alex99.heroapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex99.heroapp.data.modelos.Conexiones
import com.alex99.heroapp.dominio.ObtenerCon
import kotlinx.coroutines.launch

private const val TAG = "PruebaViewModelBio"

class ConViewModel: ViewModel()  {
    val conModel = MutableLiveData<Conexiones>()


    fun onCreate(id:String){
        viewModelScope.launch {
            val result = ObtenerCon(id)()
            Log.d(TAG,"Regresa ${result.groupAffiliation}")
            conModel.postValue(result)
        }
    }
}