package com.example.extraorinarioproyectoerroresdepliculas

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.extraorinarioproyectoerroresdepliculas.databinding.ActivityMainBinding
import com.example.extraorinarioproyectoerroresdepliculas.modelo.Usuario

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var intentRegistro: Intent
    private lateinit var intentPantallaInicio: Intent
    private lateinit var usuariosDB : miSqulUsario
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Inicio de secion"
        usuariosDB = miSqulUsario(this)

        binding.btnInicarSecion.setOnClickListener {

            val us =  Usuario()// varible de tipo usario para guardar los dato s

            val usuario2 = Usuario()
            // creamos un alista de usarios

            var listaDeUusaios: MutableList<Usuario> = mutableListOf()
            us.contrasenia = binding.editTextContrasenia.text.toString()

            us.correoElectronico = binding.editTextCorreo.text.toString()
            // revisamos que los campos cumplan con las resticiiones
            // validamos que ningun campo sea vacio
            if(!us.contrasenia.isEmpty()&&!us.correoElectronico.isEmpty()){
                /** ahora hacemos cumplir las restricciones tanto del correo como la contraseña
                 *  el correo no debe de tener espacios en blanco, la contraseña debe de ser mayor de 3 y menor o igual a 8
                */
                // primeor vemos qu la contraseña este en rango  3 - 8
                var cumpleContrasnia = false
                if(us.contrasenia.length>3 && us.contrasenia.length <=8){
                    cumpleContrasnia= true
                }else{
                    Toast.makeText(this,"La contraseña debe de estar en el rango de 3 a 8",Toast.LENGTH_LONG).show()
                }// fin del if que comprueba que la contraseña cumple

                // ahora hacemos que el correo cumpla
                var cumpleCorreo = false
                val tamanioCorreo =  us.correoElectronico.length
                var contadorDeCacteres = 0
                var indiceCaracter= 0
                while (indiceCaracter< tamanioCorreo){
                    if(!us.correoElectronico.get(indiceCaracter).equals(" ")){
                        contadorDeCacteres++
                      //  Log.d("Caracter","${us.correoElectronico.get(indiceCaracter)}")
                    }else{
                        break
                    }
                    indiceCaracter++
                }// fin del while

                if(tamanioCorreo == contadorDeCacteres){
                      cumpleCorreo= true
                }
                Log.d("tamCorreo","tamaño del correo  ${tamanioCorreo} Tmaño de los caracteres ${contadorDeCacteres}")
                // ahora si ambos cumplen comprobamos si los datos ingresados som correctos
               /*
                if(cumpleCorreo){
                        Toast.makeText(this,"Correo cumple",Toast.LENGTH_LONG).show()
                }else{
                        Toast.makeText(this,"El correo no debe de tener espacios en blanco",Toast.LENGTH_LONG).show()
                }*/

            }else{// else de validar vacio
                Toast.makeText(this,"Los campos estan vacios ",Toast.LENGTH_LONG).show()
            }// fin del if que comprueba si los datos son vacios

                // obtenemos los los datos de la base de datos.
                val db : SQLiteDatabase = usuariosDB.readableDatabase

                val cursor =  db.rawQuery("SELECT * FROM usuariosT",null)
                var seEncontro = false
                if(cursor.moveToFirst()){

                    while (cursor.moveToNext()){

                        usuario2.nombreusuario = cursor.getString(1)

                        usuario2.correoElectronico = cursor.getString(2)

                        usuario2.contrasenia = cursor.getString(3)
                        listaDeUusaios.add(usuario2)// los guardamos en ua lista
                        Log.d("ehile", "${listaDeUusaios.get(0).correoElectronico}")
                        // comprobamos si el dato obtenido es correcto.
                        if(listaDeUusaios.get(0).correoElectronico.equals(us.correoElectronico)&&listaDeUusaios.get(0).contrasenia.equals(us.contrasenia)){
                            seEncontro = true
                            break
                        }
                    }
                }else{
                    Toast.makeText(this,"No hay usuarios",Toast.LENGTH_SHORT).show()
                }
                if(seEncontro){
                    Toast.makeText(this,"Bienvenido",Toast.LENGTH_SHORT).show()
                    intentPantallaInicio = Intent(this,home::class.java)
                    startActivity(intentPantallaInicio)
                }else{
                    Toast.makeText(this,"Datos incorrectos",Toast.LENGTH_SHORT).show()
                }

        }// fin del escucha de inico de secion
        // boton de texto que nos permite dar de alta al usuario.
        binding.textNoTienesCuenta.setOnClickListener{
            intentRegistro = Intent(this, dardeAltaUsuario::class.java)
            startActivity(intentRegistro)
        }// fin del escucha de clics.
    }// fin del oncreate

}// fin de la clase