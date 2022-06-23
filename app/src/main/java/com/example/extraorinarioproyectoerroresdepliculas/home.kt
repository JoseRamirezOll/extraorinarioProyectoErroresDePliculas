package com.example.extraorinarioproyectoerroresdepliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.example.extraorinarioproyectoerroresdepliculas.databinding.ActivityHomeBinding

class home : AppCompatActivity() {
    private  lateinit var  binding: ActivityHomeBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Errores de peliculas"
        // creamos una variable de tipo navegation

        val fragmentoHome  = homeFragment()
        val fregmentoBuscar = buscarFragment()
        val freagemntoPelis = peliculasFragment()
        val fragemntoSeries = seriesFragment()

        // menu inferior
        binding.botonesnavegacion.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.inicio ->{
                    setFragment(fragmentoHome)
                    true
                }
                R.id.buscar ->{
                    setFragment(fregmentoBuscar)
                    true
                }
                R.id.pelicula ->{
                    setFragment(freagemntoPelis)
                    true
                }
                R.id.series->{
                    setFragment(fragemntoSeries)
                    true
                }
                else -> false
            }// fin del when
        }// fin del set on navegation
    }
    private fun setFragment(fragments: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.botonesnavegacion,fragments)
            commit()
        }// fin del apply
    }
}