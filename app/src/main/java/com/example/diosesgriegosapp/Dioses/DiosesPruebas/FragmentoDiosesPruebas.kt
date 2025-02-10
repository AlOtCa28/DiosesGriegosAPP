package com.example.diosesgriegosapp.Dioses.DiosesPruebas

import Adaptadores.AdaptadorPrueba
import Modelo.Prueba.Prueba
import Modelo.Usuario.Usuario
import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diosesgriegosapp.databinding.FragmentFragmentoDiosesPruebasBinding

class FragmentoDiosesPruebas : Fragment() {
    private var _binding: FragmentFragmentoDiosesPruebasBinding? = null
    private val binding get() = _binding!!

    private val diosesPruebasViewModel: FragmentoDiosesPruebasViewModel by viewModels()
    var datosRepresentar : ArrayList<Prueba> = ArrayList()
    lateinit var adaptadorRV : AdaptadorPrueba


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFragmentoDiosesPruebasBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        diosesPruebasViewModel.getUsuariosVM()

        diosesPruebasViewModel.myResponseList.observe(viewLifecycleOwner) { responseList ->
            datosRepresentar.clear()
            datosRepresentar.addAll(responseList)
            adaptadorRV.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        adaptadorRV = AdaptadorPrueba(requireContext(), datosRepresentar)
        binding.RvPruebas.layoutManager = LinearLayoutManager(requireContext())
        binding.RvPruebas.adapter = adaptadorRV
    }
}