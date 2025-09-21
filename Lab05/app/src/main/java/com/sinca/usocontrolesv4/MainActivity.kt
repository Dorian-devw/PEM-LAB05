package com.sinca.usocontrolesv4

import android.os.Bundle
import android.widget.*
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtUsuario = findViewById<EditText>(R.id.txtusuario)
        val txtClave = findViewById<EditText>(R.id.txtclave)
        val btnOk = findViewById<Button>(R.id.btnOk)
        val tglOnOff = findViewById<ToggleButton>(R.id.tglOnOff)
        val lblResultado = findViewById<TextView>(R.id.lblResultado)
        val lblVer = findViewById<TextView>(R.id.lblver)

        btnOk.setOnClickListener {
            val usuario = txtUsuario.text.toString()
            val clave = txtClave.text.toString()

            if (usuario.isNotEmpty() && clave.isNotEmpty()) {
                lblResultado.text = "Bienvenido $usuario"
                lblVer.text = "Usuario autenticado correctamente"
            } else {
                lblResultado.text = "Faltan datos"
                lblVer.text = "Por favor ingrese usuario y clave"
            }
        }

        tglOnOff.setOnCheckedChangeListener { _, isChecked ->
            lblVer.text = if (isChecked) "Acceso habilitado" else "Acceso deshabilitado"
        }
    }
}