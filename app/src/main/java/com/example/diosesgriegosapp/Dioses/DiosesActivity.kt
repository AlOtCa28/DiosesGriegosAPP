package com.example.diosesgriegosapp.Dioses

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.diosesgriegosapp.Login.MainActivity
import com.example.diosesgriegosapp.R
import com.example.diosesgriegosapp.databinding.ActivityDiosesBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class DiosesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDiosesBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDiosesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.mtbMenu)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.miFragContainer) as NavHostFragment
        navController = navHostFragment.navController

        val navView: BottomNavigationView = binding.btvMenu
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_humanos, R.id.navigation_Pruebas
            )
        )
        navView.setupWithNavController(navController)

        supportActionBar?.title = "Dioses Griegos App"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
        return true
    }
}