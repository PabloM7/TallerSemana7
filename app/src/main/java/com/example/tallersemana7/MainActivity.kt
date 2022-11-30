package com.example.tallersemana7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_formulario=findViewById<Button>(R.id.btn_formulario)
        btn_formulario.setOnClickListener{
            val saltar:Intent=Intent(this, DatosMascota::class.java)
            startActivity(saltar)
        }
        btn_login.setOnClickListener{
            val saltar2:Intent=Intent(this, Auth_activity::class.java)
            startActivity(saltar2)
        }
        btn_listado.setOnClickListener{
            val saltar3:Intent=Intent(this, Listado::class.java)
            startActivity(saltar3)
        }
    }
}