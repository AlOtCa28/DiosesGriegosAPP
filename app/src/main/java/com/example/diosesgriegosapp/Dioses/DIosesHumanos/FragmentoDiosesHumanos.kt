package com.example.diosesgriegosapp.Dioses.DIosesHumanos

import Adaptadores.MiAdaptadorRV
import Modelo.Usuario
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diosesgriegosapp.R
import com.example.diosesgriegosapp.databinding.FragmentFragmentoDiosesHumanosBinding

class FragmentoDiosesHumanos : Fragment() {
    private var _binding: FragmentFragmentoDiosesHumanosBinding? = null
    private val binding get() = _binding!!

    private val diosesHumanosViewModel: FragmentoDiosesHumanosViewModel by viewModels()
    var datosRepresentar : ArrayList<Usuario> = ArrayList()
    lateinit var adaptadorRV : MiAdaptadorRV



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFragmentoDiosesHumanosBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        diosesHumanosViewModel.getUsuariosVM()

        diosesHumanosViewModel.myResponseList.observe(viewLifecycleOwner) { usuarios ->
            datosRepresentar.clear()
            datosRepresentar.addAll(usuarios.filter { it.rol == 2 })
            adaptadorRV.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.RVListaPersonas.layoutManager = linearLayoutManager
        adaptadorRV = MiAdaptadorRV(requireContext(), datosRepresentar)
        binding.RVListaPersonas.adapter = adaptadorRV
    }
}