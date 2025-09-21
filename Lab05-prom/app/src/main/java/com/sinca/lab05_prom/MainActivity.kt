package com.sinca.lab05_prom

import android.os.Bundle
import android.widget.*
import androidx.activity.ComponentActivity

class Promedio : ComponentActivity() {
    data class Alumno(val nombre: String, var promedioFinal: Double)

    private val listaAlumnos = mutableListOf<Alumno>()
    private var alumnoActual = 1
    private val totalAlumnos = 3  // mínimo 3 alumnos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val camposTeoria = listOf<EditText>(
            findViewById(R.id.t1), findViewById(R.id.t2),
            findViewById(R.id.t3), findViewById(R.id.t4)
        )
        val camposLab = listOf<EditText>(
            findViewById(R.id.l1), findViewById(R.id.l2), findViewById(R.id.l3), findViewById(R.id.l4),
            findViewById(R.id.l5), findViewById(R.id.l6), findViewById(R.id.l7), findViewById(R.id.l8)
        )
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val btnSustitutorio = findViewById<Button>(R.id.btnSustitutorio)
        val lblResultado = findViewById<TextView>(R.id.lblResultado)

        btnCalcular.setOnClickListener {
            val notasTeoria = camposTeoria.mapNotNull { it.text.toString().toDoubleOrNull() }
            val notasLab = camposLab.mapNotNull { it.text.toString().toDoubleOrNull() }

            if (!validarNotas(notasTeoria + notasLab)) {
                lblResultado.text = "Notas inválidas, ingrese valores de 0 a 20"
                return@setOnClickListener
            }

            if (notasTeoria.size < 4 || notasLab.size < 8) {
                lblResultado.text = "Debe llenar todas las notas"
                return@setOnClickListener
            }

            val promTeoria = notasTeoria.sortedDescending().take(3).average()
            val promLab = notasLab.average()
            var promedioFinal = (promTeoria * 0.30) + (promLab * 0.70)

            lblResultado.text = "Prom. Teoría: %.2f\nProm. Lab: %.2f\nPromedio Final: %.2f".format(promTeoria, promLab, promedioFinal)

            if (promedioFinal < 10.5) {
                lblResultado.append("\nDESAPROBADO - Debe rendir sustitutorio")
                btnSustitutorio.visibility = Button.VISIBLE
            } else {
                lblResultado.append("\nAPROBADO ✅")
                guardarAlumno(promedioFinal)
            }

            btnSustitutorio.setOnClickListener {
                pedirSustitutorio(promedioFinal, notasTeoria, notasLab, lblResultado)
            }
        }
    }

    private fun validarNotas(notas: List<Double>): Boolean {
        return notas.all { it in 0.0..20.0 }
    }

    private fun pedirSustitutorio(
        promedioFinal: Double,
        notasTeoria: List<Double>,
        notasLab: List<Double>,
        lblResultado: TextView
    ) {
        val input = EditText(this)
        input.hint = "Ingrese nota de sustitutorio (0-20)"
        input.inputType = android.text.InputType.TYPE_CLASS_NUMBER or android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL

        val dialog = android.app.AlertDialog.Builder(this)
            .setTitle("Nota de Sustitutorio")
            .setView(input)
            .setPositiveButton("Recalcular") { _, _ ->
                val sustitutorio = input.text.toString().toDoubleOrNull()
                if (sustitutorio != null && sustitutorio in 0.0..20.0) {
                    val todasNotas = notasTeoria + notasLab
                    val notaMin = todasNotas.minOrNull() ?: 0.0
                    val listaReemplazo = todasNotas.toMutableList()
                    listaReemplazo[listaReemplazo.indexOf(notaMin)] = sustitutorio

                    val promTeoria = listaReemplazo.take(4).sortedDescending().take(3).average()
                    val promLab = listaReemplazo.drop(4).average()
                    val nuevoPromedio = (promTeoria * 0.30) + (promLab * 0.70)

                    lblResultado.text = "Nuevo Promedio: %.2f".format(nuevoPromedio)
                    if (nuevoPromedio >= 10.5) {
                        lblResultado.append("\nAPROBADO ✅")
                    } else {
                        lblResultado.append("\nDESAPROBADO ❌")
                    }
                    guardarAlumno(nuevoPromedio)
                } else {
                    Toast.makeText(this, "Nota inválida", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancelar", null)
            .create()
        dialog.show()
    }

    private fun guardarAlumno(promedio: Double) {
        listaAlumnos.add(Alumno("Alumno $alumnoActual", promedio))
        alumnoActual++
        if (alumnoActual > totalAlumnos) {
            mostrarRanking()
        }
    }

    private fun mostrarRanking() {
        val ranking = listaAlumnos.sortedByDescending { it.promedioFinal }
        val resultados = ranking.joinToString("\n") { "${it.nombre}: %.2f".format(it.promedioFinal) }
        android.app.AlertDialog.Builder(this)
            .setTitle("Ranking de Alumnos")
            .setMessage(resultados)
            .setPositiveButton("OK", null)
            .show()
    }
}