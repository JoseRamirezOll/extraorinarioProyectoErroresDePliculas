package com.example.extraorinarioproyectoerroresdepliculas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import com.example.extraorinarioproyectoerroresdepliculas.adapter.adaptadorPelicula
import com.example.extraorinarioproyectoerroresdepliculas.databinding.FragmentHomeBinding

class peliculasFragment : Fragment(R.layout.fragment_peliculas) {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)

/*
        binding.recicelhome.adapter = adaptadorPelicula(

        )
        binding.recicelhome.setHasFixedSize(true)
 */
    }
}