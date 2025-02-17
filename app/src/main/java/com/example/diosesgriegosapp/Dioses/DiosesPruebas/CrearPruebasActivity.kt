package com.example.diosesgriegosapp.Dioses.DiosesPruebas

import Modelo.Prueba.Prueba
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.diosesgriegosapp.R
import com.example.diosesgriegosapp.databinding.ActivityCrearPruebasBinding

class CrearPruebasActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCrearPruebasBinding
    private val viewModel: FragmentoDiosesPruebasViewModel by viewModels()


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
            val nombre = binding.edtTipoPrueba.text.toString()
            val descripcion = binding.edtDescripcion.text.toString()
            val dificultad = binding.edtDificultad.text.toString().toInt()
            val atributo = binding.edtAtributo.text.toString()
            val impacto = binding.edtImpacto.text.toString().toInt()
            val palabraClave = binding.edtPalbraclave.text.toString()

            if (nombre.isEmpty() || descripcion.isEmpty()) {
                return@setOnClickListener
            }else{
                viewModel.CrearPruebaVM(Prueba(0,1, nombre, descripcion,  atributo, dificultad, impacto, palabraClave))
            }
        }

        binding.btnCancelar2.setOnClickListener {
            finish()
        }
    }
}