package com.example.diosesgriegosapp.Dioses.DiosesPruebas

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diosesgriegosapp.R

class FragmentoDiosesPruebas : Fragment() {

    companion object {
        fun newInstance() = FragmentoDiosesPruebas()
    }

    private val viewModel: FragmentoDiosesPruebasViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_fragmento_dioses_pruebas, container, false)
    }
}