package com.example.diosesgriegosapp.Login


import Modelo.UsuarioLogIn
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.diosesgriegosapp.Dioses.DiosesActivity
import com.example.diosesgriegosapp.Humanos.HumanosActivity
import com.example.diosesgriegosapp.R

import com.example.diosesgriegosapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var loginViewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)


        loginViewModel.myResponse.observe(this, Observer { user ->
            user?.let {
                if (binding.edtNombre.text.isEmpty() || binding.edtEmail.text.isEmpty() || binding.estContra.text.isEmpty()) {
                    Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show()
                } else {
                    val intent = if (it.rol == 1) {
                        Intent(this, DiosesActivity::class.java)
                    } else {
                        Intent(this, HumanosActivity::class.java)
                    }
                    startActivity(intent)
                    Parametros.Parametros.usuarioLogeado = binding.edtNombre.text.toString()
                    limpiar()
                    loginViewModel.limpiarRespuesta()
                }
            }
        })

        binding.btnLogin.setOnClickListener {
            if (binding.edtEmail.text.isEmpty() || binding.edtNombre.text.isEmpty() || binding.estContra.text.isEmpty()) {
                Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                loginViewModel.loginVM(UsuarioLogIn(binding.edtNombre.text.toString(), binding.edtEmail.text.toString() ,binding.estContra.text.toString()))
            }
        }


        loginViewModel.errorCode.observe(this) { errorCode ->
            if (errorCode != null) {
                when (errorCode) {
                    200 -> Toast.makeText(this, "Sesion Iniciada", Toast.LENGTH_SHORT).show()
                    400 -> Toast.makeText(this,"Error 400: Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                    404 -> Toast.makeText(this, "Error 404: El usuario no existe", Toast.LENGTH_SHORT).show()
                    else -> Toast.makeText(this, "Error Desconocido", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnSalir.setOnClickListener {
            finish()
        }
    }

    private fun limpiar() {
        binding.edtEmail.text.clear()
        binding.edtNombre.text.clear()
        binding.estContra.text.clear()
    }
}