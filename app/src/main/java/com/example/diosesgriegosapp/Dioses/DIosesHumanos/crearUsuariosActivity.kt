package com.example.diosesgriegosapp.Dioses.DIosesHumanos

import Modelo.Usuario.Usuario
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.diosesgriegosapp.Login.LoginViewModel
import com.example.diosesgriegosapp.R
import com.example.diosesgriegosapp.databinding.ActivityCrearUsuariosBinding
import com.example.diosesgriegosapp.databinding.ActivityMainBinding

class crearUsuariosActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCrearUsuariosBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCrearUsuariosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnCrearUsuario.setOnClickListener {
            val nombre = binding.edtNombreNuevo.text.toString()
            val email = binding.edtEmailNuevo.text.toString()
            val password = binding.edtContraseANueva.text.toString()
            val rol = binding.edtRol.text.toString().toInt()
            val estado = binding.edtEstadoNuevo.text.toString().toInt()
            val foto = binding.edtFoto.text.toString()
            val destino = binding.edtDestino.text.toString().toInt()

            if (nombre.isEmpty() || email.isEmpty() || password.isEmpty()) {
                return@setOnClickListener
            }else{
                val usuario = Usuario(
                    nombre = nombre,
                    email = email,
                    contraseña = password,
                    rol = rol,
                    fotoPerfil = foto,
                    estado = estado,
                    destino = destino
                )
                viewModel.CrearUsuarioVM(usuario)
                finish()
            }
        }

        binding.btnCancelar.setOnClickListener {
            finish()
        }
    }
}