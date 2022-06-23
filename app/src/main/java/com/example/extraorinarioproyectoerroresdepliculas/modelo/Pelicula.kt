package com.example.extraorinarioproyectoerroresdepliculas.modelo

import androidx.annotation.DrawableRes

data class Pelicula(
   @DrawableRes val  imagenPeliD: Int,
   val titulpPelicula: String,
   val anioPelicula: String,
   val numeroErrores:String
   )
