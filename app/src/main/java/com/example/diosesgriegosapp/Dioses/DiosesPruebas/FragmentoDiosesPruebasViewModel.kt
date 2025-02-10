package com.example.diosesgriegosapp.Dioses.DiosesPruebas

import API.UserNetwork
import Modelo.Prueba.Prueba
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class FragmentoDiosesPruebasViewModel : ViewModel() {

    private val _myResponse = MutableLiveData<List<Prueba>>()
    val myResponse: LiveData<List<Prueba>> get() = _myResponse

    private val _myResponseList = MutableLiveData<List<Prueba>>()
    val myResponseList: LiveData<List<Prueba>> get() = _myResponseList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _resOperacion = MutableLiveData<Boolean>()
    val resOperacion: LiveData<Boolean> get() = _resOperacion

    private val _errorCode = MutableLiveData<Int?>()
    val errorCode: LiveData<Int?> get() = _errorCode

    fun getUsuariosVM() {
        viewModelScope.launch {
            _isLoading.value = true
            var response: Response<MutableList<Prueba>> = UserNetwork.retrofitPrueba.listarPruebas()

            if (response.isSuccessful) {
                _myResponseList.value = response.body()
            } else {
                _myResponseList.value = emptyList()
                _errorCode.value = response.code()
            }
            _isLoading.value = false
        }
    }
}