package com.example.diosesgriegosapp.Dioses.DiosesPruebas

import Modelo.Prueba.Prueba
import Parametros.Parametros
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.diosesgriegosapp.Humanos.Perfil.PerfilActivityViewModel
import com.example.diosesgriegosapp.Login.LoginViewModel
import com.example.diosesgriegosapp.R
import com.example.diosesgriegosapp.databinding.ActivityCrearPruebasBinding

class CrearPruebasActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCrearPruebasBinding

    private val viewModel: FragmentoDiosesPruebasViewModel by viewModels()
    private val perfilviewmodel: PerfilActivityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCrearPruebasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.btnCrearPruebanueva.setOnClickListener {
            try {
                val nombreusuario = Parametros.usuarioLogeado
                val nombre = binding.edtTipoPrueba.text.toString()
                val descripcion = binding.edtDescripcion.text.toString()
                val dificultad = binding.edtDificultad.text.toString().toIntOrNull()
                val atributo = binding.edtAtributo.text.toString()
                val impacto = binding.edtImpacto.text.toString().toIntOrNull()
                val palabraClave = binding.edtPalbraclave.text.toString()

                if (nombreusuario != null && nombre.isNotEmpty() && descripcion.isNotEmpty() && dificultad != null && impacto != null) {
                    perfilviewmodel.obtenerUsuarioPorNombreVM(nombreusuario)
                    perfilviewmodel.myResponse.observe(this) { usuario ->
                        usuario?.let {
                            val idUsuario = it.idUsuario
                            if (idUsuario != null) {
                                val nuevaPrueba = Prueba(0, idUsuario, nombre, descripcion, atributo, dificultad, impacto, palabraClave)
                                viewModel.CrearPruebaVM(nuevaPrueba)
                                viewModel.resOperacion.observe(this) { success ->
                                    if (success) {
                                        Toast.makeText(this, "Prueba creada exitosamente", Toast.LENGTH_SHORT).show()
                                        finish()
                                    } else {
                                        Toast.makeText(this, "Error al crear la prueba", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }
                        }
                    }
                } else {
                    Toast.makeText(this, "Por favor, completa todos los campos correctamente", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnCancelar2.setOnClickListener {
            finish()
        }
    }
}