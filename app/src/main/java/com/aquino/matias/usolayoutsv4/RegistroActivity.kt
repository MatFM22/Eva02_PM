package com.aquino.matias.usolayoutsv4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistroActivity : AppCompatActivity() {

    // Declarar las variables para las vistas
    private lateinit var nombreCliente: EditText
    private lateinit var numeroCliente: EditText
    private lateinit var productos: EditText
    private lateinit var ciudad: EditText
    private lateinit var direccion: EditText
    private lateinit var btnRegistrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ejercicio02) // Asegúrate de que el layout correcto esté referenciado aquí

        // Inicializar las vistas usando findViewById
        nombreCliente = findViewById(R.id.nombreCliente)
        numeroCliente = findViewById(R.id.numeroCliente)
        productos = findViewById(R.id.productos)
        ciudad = findViewById(R.id.ciudad)
        direccion = findViewById(R.id.direccion)
        btnRegistrar = findViewById(R.id.btnRegistrar)

        // Configurar el evento click para el botón Registrar
        btnRegistrar.setOnClickListener {
            val nombre = nombreCliente.text.toString()
            val numero = numeroCliente.text.toString()
            val productos = productos.text.toString()
            val ciudad = ciudad.text.toString()
            val direccion = direccion.text.toString()

            // Validar que los campos no estén vacíos
            if (nombre.isEmpty() || numero.isEmpty() || productos.isEmpty() || ciudad.isEmpty() || direccion.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Enviar los datos a PedidoActivity
                val intent = Intent(this, PedidoActivity::class.java)
                intent.putExtra("nombre", nombre)
                intent.putExtra("numero", numero)
                intent.putExtra("productos", productos)
                intent.putExtra("direccion", direccion)
                startActivity(intent)
            }
        }
    }
}
