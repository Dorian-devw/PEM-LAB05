package com.sinca.usocontrolesv4

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.EditText
import android.widget.Button
import android.widget.*


class Calculadora : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)

        val txtTotalCuenta = findViewById<EditText>(R.id.txtTotalCuenta)
        val txtPersonas = findViewById<EditText>(R.id.txtPersonas)
        val spPropina = findViewById<Spinner>(R.id.spPropina)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val lblResultado = findViewById<TextView>(R.id.lblResultadoPropina)

        val porcentajes = arrayOf("5%", "10%", "15%", "20%")
        spPropina.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, porcentajes)

        btnCalcular.setOnClickListener {
            val total = txtTotalCuenta.text.toString().toDoubleOrNull()
            val personas = txtPersonas.text.toString().toIntOrNull()
            val porcentajeSeleccionado = spPropina.selectedItem.toString().replace("%", "").toDoubleOrNull()

            if (total != null && personas != null && porcentajeSeleccionado != null) {
                val propina = total * (porcentajeSeleccionado / 100)
                val totalPagar = total + propina
                val porPersona = totalPagar / personas

                lblResultado.text = "Propina: S/ %.2f\nTotal: S/ %.2f\nPor Persona: S/ %.2f".format(propina, totalPagar, porPersona)
            } else {
                lblResultado.text = "Por favor complete todos los campos correctamente"
            }
        }
    }
}