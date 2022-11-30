package com.example.tallersemana7


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.activity_datos_mascota.*

enum class ProviderType {
    BASIC,
    GOOGLE,
    FACEBOOK
}

class DatosMascota : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_mascota)
        val bundle: Bundle? = intent.extras
        val email: String? = bundle?.getString("email")
        val provider: String? = bundle?.getString("provider")
        setup(email ?: "", provider ?: "")
    }

    private fun setup(email: String, provider: String) {
        title = "Datos de Mascota"
        tv_mail.text = email
        tv_clave.text = provider
        btn_guardar.setOnClickListener() {
            db.collection("mascotas").document().set(
                hashMapOf(
                    "nombre" to et_nombre.text.toString(),
                    "edad" to et_edad.text.toString(),
                    "raza" to et_raza.text.toString(),
                    "numero de vacunas" to et_nvacunas.text.toString(),
                    "fecha de la ultima vacuna" to et_ultimavacuna.text.toString(),
                    "enfermedades" to et_enfermedades.text.toString()
                )
            )
        }
    }
}