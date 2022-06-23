package com.example.extraorinarioproyectoerroresdepliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import com.example.extraorinarioproyectoerroresdepliculas.databinding.ActivityDardeAltaUsuarioBinding
import com.example.extraorinarioproyectoerroresdepliculas.modelo.Usuario
//
class dardeAltaUsuario : AppCompatActivity() {
    private lateinit var binding:ActivityDardeAltaUsuarioBinding
    private lateinit var usuariosDB : miSqulUsario
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDardeAltaUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title ="Registrarse"

        val us =  Usuario()
        binding.btnRegistrar.setOnClickListener {

            us.nombreusuario = binding.edidTexNombreDeUsuario.text.toString()
            us.correoElectronico= binding.editTextTextEmailAddress.text.toString()
            val contra1= binding.editTextTextPassword2.text.toString()
            val contra2 = binding.editTextTextPassword.text.toString()
                // if que revisa si las contraseñas coinsiden
                if(contra1.length>3&&contra1.length<=8&&contra1.length>3&&contra1.length<=8){
                    if(contra1.equals(contra2)){
                        us.contrasenia = binding.editTextTextPassword2.text.toString()
                        usuariosDB = miSqulUsario(this)
                        usuariosDB.agregarUsuario(us)
                        Toast.makeText(this, "Ah sido registrado",Toast.LENGTH_LONG).show()
                        limpiarCampos()
                    }else{
                        Toast.makeText(this, "No coinsiden las contraseñas",Toast.LENGTH_LONG).show()
                    }// fin del if  que dice si las contraseñas son iguales

                }// fin del if que indica si las contraseñas coinsiden
                else{
                    Toast.makeText(this, " el tamaño de las contraseñas no es el esperado 3 a 8 caracteres",Toast.LENGTH_LONG).show()
                    limpiarCampos()
                }// fin del else
        }// fin del boton de registrar .

    }// fin del oncreate
 fun limpiarCampos(){
     binding.edidTexNombreDeUsuario.text.clear()
     binding.editTextTextEmailAddress.text.clear()
     binding.editTextTextPassword.text.clear()
     binding.editTextTextPassword2.text.clear()
 }
}// fin del la clase