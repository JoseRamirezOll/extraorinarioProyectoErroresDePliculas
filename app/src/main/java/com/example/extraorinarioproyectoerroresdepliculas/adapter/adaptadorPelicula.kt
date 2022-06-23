package com.example.extraorinarioproyectoerroresdepliculas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.extraorinarioproyectoerroresdepliculas.R
import com.example.extraorinarioproyectoerroresdepliculas.data.dataPelis


class adaptadorPelicula(private  val contex : Context):RecyclerView.Adapter<adaptadorPelicula.PelisAdapterCardViewHolder>()
{// fin del la clase adaptador pelis
    // acedemos a los datos
    var datos = dataPelis.pelis

    class PelisAdapterCardViewHolder(view: View?):RecyclerView.ViewHolder(view!!){
        val imagenPeli : ImageView= view!!.findViewById(R.id.imagenPeli)
        val tituloPeli  : TextView = view!!.findViewById(R.id.tituloPeli)
        val anioPeli: TextView = view!!.findViewById(R.id.textAnio)
        val errorPEli : TextView = view!!.findViewById(R.id.textErrores)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PelisAdapterCardViewHolder {
        val adapter =LayoutInflater.from(parent.context).inflate(R.layout.cardpelicula,parent,false)
        return PelisAdapterCardViewHolder(adapter)
    }
    override fun getItemCount(): Int = datos.size // sacamos el tamaño de la lista

    override fun onBindViewHolder(holder: PelisAdapterCardViewHolder, position: Int) {

        val recursos =datos[position]

        holder.imagenPeli.setImageResource(recursos.imagenPeliD)
        holder.tituloPeli.text =contex?.getString(R.string.StringValueTituloPeli,recursos.titulpPelicula)
        holder.anioPeli.text = contex?.getString(R.string.StringValueAnioPeli,recursos.anioPelicula)
        holder.errorPEli.text =contex?.getString(R.string.StringValueErroersNum,recursos.numeroErrores)

    }// fin del onBin
}