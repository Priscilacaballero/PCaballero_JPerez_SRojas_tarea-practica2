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

class FragmentOption5 : Fragment() {
    private var selectedPlanet: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_option5, container, false)

        val planetSpinner: Spinner = view.findViewById(R.id.Planetas_spinner)
        val btnSend: Button = view.findViewById(R.id.btn_send)

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

        // Mostrar el mensaje cuando se presiona el botón
        btnSend.setOnClickListener {
            selectedPlanet?.let {
                Toast.makeText(requireContext(), "Has escogido el planeta $it", Toast.LENGTH_SHORT).show()
            } ?: run {
                Toast.makeText(requireContext(), "No has seleccionado ningún planeta", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
