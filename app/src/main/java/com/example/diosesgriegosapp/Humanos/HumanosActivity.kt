package com.example.diosesgriegosapp.Humanos

import Adaptadores.AdaptadorPrueba
import Adaptadores.AdaptadorPruebaHumano
import Adaptadores.MiAdaptadorRV
import Modelo.Prueba.Prueba
import Modelo.Usuario.Usuario
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diosesgriegosapp.Dioses.DiosesPruebas.FragmentoDiosesPruebasViewModel
import com.example.diosesgriegosapp.Humanos.Perfil.PerfilActivity
import com.example.diosesgriegosapp.Login.MainActivity
import com.example.diosesgriegosapp.R
import com.example.diosesgriegosapp.databinding.ActivityHumanosBinding

class HumanosActivity : AppCompatActivity() {
    lateinit var binding: ActivityHumanosBinding
    private val viewModel: HumanosViewModel by viewModels()

    private val diosesPruebasViewModel: FragmentoDiosesPruebasViewModel by viewModels()
    private lateinit var adaptadorRV: AdaptadorPruebaHumano
    private var datosRepresentar: ArrayList<Prueba> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHumanosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        adaptadorRV = AdaptadorPruebaHumano(this, datosRepresentar)

        binding.rvPruebasAsignadas.layoutManager = LinearLayoutManager(this)
        binding.rvPruebasAsignadas.adapter = adaptadorRV

        diosesPruebasViewModel.getUsuariosVM()

        diosesPruebasViewModel.myResponseList.observe(this) { pruebas ->
            datosRepresentar.clear()
            datosRepresentar.addAll(pruebas)
            adaptadorRV.notifyDataSetChanged()
        }

        setSupportActionBar(binding.mtbHumanos)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_hamburguesa, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_perfil -> {
                val intent = Intent(this, PerfilActivity::class.java)
                startActivity(intent)
                true
            }
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}