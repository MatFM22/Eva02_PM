package com.aquino.matias.usolayoutsv4

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialización de vistas usando findViewById
        val showButton = findViewById<Button>(R.id.showButton)
        val hideButton = findViewById<Button>(R.id.hideButton)
        val greenView = findViewById<View>(R.id.greenView)

        // Botón Mostrar
        showButton.setOnClickListener {
            greenView.visibility = View.VISIBLE
        }

        // Botón Ocultar
        hideButton.setOnClickListener {
            greenView.visibility = View.GONE
        }
    }
}
