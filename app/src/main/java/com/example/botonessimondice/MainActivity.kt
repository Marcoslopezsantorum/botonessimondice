package com.example.botonessimondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    val miBoton: Button = findViewById(R.id.mibutton)

    // declaramos el listener del boton
    miBoton.setOnClickListener{

        lanzarCorrutina()

         }
    }
    var job: Job? = null//u  fghfgh
    var job2: Job? = null

    private fun lanzarCorrutina() {

        val miTexto: TextView = findViewById(R.id.mitextView)

    // 'launch' se encarga de crear una corrutina
    // vamos a poder identificarla con 'job'
    val job = GlobalScope.launch(Dispatchers.Main) {

        // llamamos a una funcion que estara dentro de la corrutina
        // en esta funcion habrá un delay()
        suspendingTask(miTexto)
         }

        val job2 = GlobalScope.launch(Dispatchers.Main) {

            // llamamos a una funcion que estara dentro de la corrutina
            // en esta funcion habrá un delay()
            job.join()
            suspendingTask2(miTexto)
        }

    }

    suspend private fun suspendingTask2(miTexto: TextView) {
        delay(1500L)
        miTexto.text = "Task2"
    }

    suspend fun suspendingTask(miTexto: TextView) {
        miTexto.text = "Hola"
    delay(3000L)
    miTexto.text="Corrutina"
    }
}