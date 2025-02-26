package com.example.diosesgriegosapp.Humanos.Perfil

import API.UserNetwork
import Modelo.Usuario.Usuario
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class PerfilActivityViewModel : ViewModel() {

    private val _myResponse = MutableLiveData<Usuario?>()
    val myResponse: LiveData<Usuario?> get() = _myResponse

    private val _myResponseList = MutableLiveData<List<Usuario>>()
    val myResponseList: LiveData<List<Usuario>> get() = _myResponseList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _resOperacion = MutableLiveData<Boolean>()
    val resOperacion: LiveData<Boolean> get() = _resOperacion

    private val _errorCode = MutableLiveData<Int?>()
    val errorCode: LiveData<Int?> get() = _errorCode

    var errorMessage: String? = null

    fun obtenerUsuarioPorNombreVM(nombre: String) {
        viewModelScope.launch {
            _isLoading.value = true
            var response: Response<Usuario> = UserNetwork.retrofit.obtenerUsuarioPorNombre(nombre)

            if (response.isSuccessful) {
                _myResponse.value = response.body()
            } else {
                _myResponse.value = null
                _errorCode.value = response.code()
            }
            _isLoading.value = false
        }
    }

    fun actualizarUsuarioVM(id: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                var response: Response<Boolean> = UserNetwork.retrofit.actualizarUsuario(id)

                if (response.isSuccessful) {
                    _resOperacion.value = true
                } else {
                    errorMessage = response.errorBody()?.string()
                    _resOperacion.value = false
                }
            } catch (e: Exception) {
                errorMessage = e.message
                _resOperacion.value = false
            }
        }
    }
}