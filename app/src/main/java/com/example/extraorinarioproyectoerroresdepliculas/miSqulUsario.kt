package com.example.extraorinarioproyectoerroresdepliculas
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.extraorinarioproyectoerroresdepliculas.modelo.Usuario

class miSqulUsario(context: Context) : SQLiteOpenHelper(
    context, "Usuarios.db",null,1) {
   // metodo para crear una tabal en la base de datos
    override fun onCreate(db: SQLiteDatabase?) {
        var crearyTabla ="CREATE TABLE usuariosT" +
                "(id_usuario INTEGER PRIMARIY KEY AUTOINCREMEN,nombreUusario TEXT,correoElectronico TEXT,contraseniaUs TEXT)"
        db!!.execSQL(crearyTabla)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun  agregarUsuario(usuarioAgregar: Usuario){
        val db = this.writableDatabase
        val datos = ContentValues()
        datos.put("nombreUusario",usuarioAgregar.nombreusuario)
        datos.put("correoElectronico",usuarioAgregar.correoElectronico)
        datos.put("contraseniaUs",usuarioAgregar.contrasenia)
        db.insert("usuariosT",null,datos)
        db.close()
    }// funcion para agregar los datos a la base de datos.

} // fin de la als que conecta a la base de datos
