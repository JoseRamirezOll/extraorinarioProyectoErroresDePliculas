package com.example.extraorinarioproyectoerroresdepliculas
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.extraorinarioproyectoerroresdepliculas.modelo.PeliculaBd

class miSqulErrores(context: Context) : SQLiteOpenHelper(
    context, "Usuarios.db",null,1) {
   // metodo para crear una tabal en la base de datos
    override fun onCreate(db: SQLiteDatabase?) {
        var crearyTabla ="CREATE TABLE erroresT" +
                "(id_error INTEGER PRIMARIY KEY AUTOINCREMEN,errorDescripcion TEXT,temporada TEXT,Capitulo TEXT)"
        db!!.execSQL(crearyTabla)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun  agregarError(usuarioError: PeliculaBd){
        val db = this.writableDatabase
        val datos = ContentValues()
        datos.put("errorDescripcion",usuarioError.errorDesc)
        datos.put("temporada",usuarioError.temporada)
        datos.put("Capitulo",usuarioError.capitulo)
        db.insert("erroresT",null,datos)
        db.close()
    }// funcion para agregar los datos a la base de datos.

    // funcion para borrar datos con el id
     fun eliminarError(idError:Int):Int{
         var idDato = arrayOf(idError.toString())
         val db = this.writableDatabase
            val comprobarBorrado = db.delete("erroresT","id_error=?",idDato)
           // db.execSQL("DElETE FROM erroresT WHERE id_error =?",idDato)
         db.close()
        return comprobarBorrado
     }
    fun editarError(id:Int,errorD:String, temporada:String,cap:String){
        val db = this.writableDatabase
        var idDato = arrayOf(id.toString())
        val datos = ContentValues()
        datos.put("errorDescripcion",errorD)
        datos.put("temporada",temporada)
        datos.put("Capitulo",cap)
        // pasamos los datos que se van amodificar
        db.update("erroresT",datos,"id_error=?",idDato)
        db.close()
    }
} // fin de la als que conecta a la base de datos