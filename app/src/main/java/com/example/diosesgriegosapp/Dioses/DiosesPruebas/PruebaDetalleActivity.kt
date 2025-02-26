package com.example.diosesgriegosapp.Dioses.DiosesPruebas

import Adaptadores.MiAdaptadorRV
import Modelo.Prueba.Prueba
import Modelo.Usuario.Usuario
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diosesgriegosapp.Dioses.DIosesHumanos.FragmentoDiosesHumanosViewModel
import com.example.diosesgriegosapp.R
import com.example.diosesgriegosapp.databinding.ActivityPruebaDetalleBinding

class PruebaDetalleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPruebaDetalleBinding

    private val diosesHumanosViewModel: FragmentoDiosesHumanosViewModel by viewModels()
    private lateinit var adaptadorRV: MiAdaptadorRV
    private var datosRepresentar: ArrayList<Usuario> = ArrayList()

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPruebaDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        adaptadorRV = MiAdaptadorRV(this, datosRepresentar)

        val prueba = intent.getSerializableExtra("prueba") as Prueba

        binding.edtTipoPrueba.setText(prueba.tipoPrueba)
        binding.edtDescripcionpRUEBA.setText(prueba.descripcion)
        binding.edtDificultadPrueba.setText(prueba.dificultad.toString())
        binding.edtImpactoPrueba.setText(prueba.impactoDestino.toString())

        binding.rvUsuariosPrueba.layoutManager = LinearLayoutManager(this)
        binding.rvUsuariosPrueba.adapter = adaptadorRV

        diosesHumanosViewModel.getUsuariosVM()

        diosesHumanosViewModel.myResponseList.observe(this) { usuarios ->
            datosRepresentar.clear()
            datosRepresentar.addAll(usuarios.filter { it.rol == 2 })
            adaptadorRV.notifyDataSetChanged()
        }

        binding.btnCancelarPrueba.setOnClickListener {
            finish()
        }
    }
}