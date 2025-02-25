package com.example.diosesgriegosapp.Login

import API.UserNetwork
import Modelo.Usuario.Usuario
import Modelo.Usuario.UsuarioLogIn
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel : ViewModel() {

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

    fun loginVM(userData: UsuarioLogIn) {
        viewModelScope.launch {
            _isLoading.value = true


            Log.d("LoginViewModel", "Sending user data: $userData")

            val response: Response<Usuario?> = UserNetwork.retrofit.iniciarSesion(userData)

            if (response.isSuccessful) {
                _myResponse.value = response.body()
                Log.d("LoginViewModel", "User data received: ${response.body()}")
                _errorCode.value = response.code()
            } else {
                _myResponse.value = null
                _errorCode.value = response.code()
            }
            _isLoading.value = false
        }
    }

    fun CrearUsuarioVM(usuario: Usuario) {
        viewModelScope.launch {
            _isLoading.value = true

            // Log the request data
            Log.d("CrearUsuarioVM", "Sending user data: $usuario")

            val response: Response<Boolean> = UserNetwork.retrofit.registrarUsuario(usuario)

            if (response.isSuccessful) {
                _resOperacion.value = response.body()
                if (response.body() == true) {
                    // Usuario creado correctamente
                    Log.d("CrearUsuarioVM", "Usuario creado correctamente")
                } else {
                    // Error al crear el usuario
                    Log.e("CrearUsuarioVM", "Error al crear el usuario")
                }
            } else {
                _resOperacion.value = false
                _errorCode.value = response.code()
                Log.e("CrearUsuarioVM", "Error en la respuesta de la API: ${response.code()}")
            }
            _isLoading.value = false
        }
    }

    fun obtenerTodosLosUsuarios(){
        viewModelScope.launch {
            _myResponseList.value = UserNetwork.retrofit.listarUsuarios().body()
        }
    }

    fun limpiarRespuesta (){
        _myResponse.value = null
    }

    fun limpiarError(){
        _errorCode.value = null
    }
}