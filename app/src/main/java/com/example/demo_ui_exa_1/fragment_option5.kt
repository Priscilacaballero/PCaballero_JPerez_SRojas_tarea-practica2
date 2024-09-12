package com.example.demo_ui_exa_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.widget.Toast
import android.widget.Button
import android.widget.TextView

class FragmentOption5 : Fragment() {
    private var selectedPlanet: String? = null

    // Mapa de descripciones de los planetas
    private val planetDescriptions = mapOf(
        "Mercurio" to "Mercurio es el planeta más cercano al Sol y el más pequeño del Sistema Solar.",
        "Venus" to "Venus es el segundo planeta desde el Sol y tiene una atmósfera muy densa.",
        "Tierra" to "La Tierra es nuestro hogar y el único planeta conocido con vida.",
        "Marte" to "Marte es conocido como el planeta rojo y tiene las montañas más altas del Sistema Solar.",
        "Júpiter" to "Júpiter es el planeta más grande del Sistema Solar, con una gran tormenta llamada la Gran Mancha Roja.",
        "Saturno" to "Saturno es famoso por sus espectaculares anillos formados por hielo y roca.",
        "Urano" to "Urano tiene un color azul debido al metano en su atmósfera y rota de manera única de lado.",
        "Neptuno" to "Neptuno es el planeta más lejano del Sol y tiene los vientos más rápidos del Sistema Solar.",
        "Plutón" to "Plutón es un planeta enano conocido por ser parte del cinturón de Kuiper."
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_option5, container, false)

        val planetSpinner: Spinner = view.findViewById(R.id.Planetas_spinner)
        val btnSend: Button = view.findViewById(R.id.btn_send)
        val txtDescripcion: TextView = view.findViewById(R.id.txt_descripcion)

        // Configuración del adaptador para el spinner
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            planetSpinner.adapter = adapter
        }

        // Guardar la selección del planeta en lugar de mostrar el mensaje inmediatamente
        planetSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedPlanet = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                selectedPlanet = null
            }
        }

        // Mostrar la descripción cuando se presiona el botón
        btnSend.setOnClickListener {
            selectedPlanet?.let { planet ->
                val description = planetDescriptions[planet]
                txtDescripcion.text = description ?: "Descripción no disponible."
            } ?: run {
                Toast.makeText(requireContext(), "No has seleccionado ningún planeta", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
