package com.example.tema8app1_save_preferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tema8app1_save_preferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val sharedPreferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)

        mainBinding.btnGuardar.setOnClickListener {
            val editor =sharedPreferences.edit()
            editor.putString("email", mainBinding.edtCorreo.text.toString())
            editor.apply()
        }

        mainBinding.btnRecuperar.setOnClickListener {
            val lector = sharedPreferences.getString("email", "Correo electronico no guardado")
            mainBinding.tvValorGuardado.text = lector
        }
    }
}