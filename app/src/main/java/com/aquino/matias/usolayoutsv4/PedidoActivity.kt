package com.aquino.matias.usolayoutsv4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PedidoActivity : AppCompatActivity() {

    // Declaración de las variables para las vistas
    private lateinit var txtNombre: TextView
    private lateinit var txtNumero: TextView
    private lateinit var txtProductos: TextView
    private lateinit var txtDireccion: TextView
    private lateinit var btnLlamar: Button
    private lateinit var btnWsp: Button
    private lateinit var btnMaps: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pedido_activity)

        // Inicializar las vistas usando findViewById
        txtNombre = findViewById(R.id.txtNombre)
        txtNumero = findViewById(R.id.txtNumero)
        txtProductos = findViewById(R.id.txtProductos)
        txtDireccion = findViewById(R.id.txtDireccion)
        btnLlamar = findViewById(R.id.btnLlamar)
        btnWsp = findViewById(R.id.btnWsp)
        btnMaps = findViewById(R.id.btnMaps)

        // Obtener los datos del Intent
        val nombre = intent.getStringExtra("nombre")
        val numero = intent.getStringExtra("numero")
        val productos = intent.getStringExtra("productos")
        val direccion = intent.getStringExtra("direccion")

        // Mostrar los datos en los TextViews
        txtNombre.text = nombre
        txtNumero.text = numero
        txtProductos.text = productos
        txtDireccion.text = direccion

        // Acción para llamar
        btnLlamar.setOnClickListener {
            val intentLlamar = Intent(Intent.ACTION_DIAL)
            intentLlamar.data = Uri.parse("tel:$numero")
            startActivity(intentLlamar)
        }

        // Acción para WhatsApp
        btnWsp.setOnClickListener {
            val mensaje = "Hola $nombre, tus productos: $productos están en camino a la dirección: $direccion"
            val uri = Uri.parse("https://api.whatsapp.com/send?phone=$numero&text=$mensaje")
            val intentWsp = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intentWsp)
        }

        // Acción para Maps
        btnMaps.setOnClickListener {
            val intentMaps = Intent(Intent.ACTION_VIEW)
            intentMaps.data = Uri.parse("geo:0,0?q=$direccion")
            intentMaps.setPackage("com.google.android.apps.maps")
            startActivity(intentMaps)
        }
    }
}


