package com.example.diosesgriegosapp.Humanos.Perfil

import Parametros.Parametros
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.diosesgriegosapp.R
import com.example.diosesgriegosapp.databinding.ActivityPerfilBinding

class PerfilActivity : AppCompatActivity() {
    lateinit var binding: ActivityPerfilBinding
    private val viewModel: PerfilActivityViewModel by viewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Parametros.usuarioLogeado?.let { viewModel.obtenerUsuarioPorNombreVM(it) }
        viewModel.myResponse.observe(this) { usuario ->
            usuario?.let {
                binding.edtNombrePerfil.setText(it.nombre)
                binding.edtEmailPerfil.setText(it.email)
                binding.edtContraPerfil.setText(it.contraseña)
                binding.edtDestinoNuevo.setText(it.destino.toString())
            }
        }


        binding.btnSalirPerfil.setOnClickListener {
            finish()
        }

        binding.btnGuardarFoto.setOnClickListener {
            // Lógica para cambiar la foto de perfil
        }

        binding.btnGuardar.setOnClickListener {
            // Lógica para guardar los cambios del perfil
        }
    }
}