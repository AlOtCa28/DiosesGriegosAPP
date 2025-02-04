package com.example.diosesgriegosapp.Dioses.DIosesHumanos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diosesgriegosapp.R

class FragmentoDiosesHumanos : Fragment() {


    companion object {
        fun newInstance() = FragmentoDiosesHumanos()
    }

    private lateinit var viewModel: FragmentoDiosesHumanosViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_fragmento_dioses_humanos, container, false)
    }
}