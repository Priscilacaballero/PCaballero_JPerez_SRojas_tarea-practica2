package com.example.demo_ui_exa_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

class FragmentOption6 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_option6, container, false)

        // Referencias a los elementos de la interfaz con los nombres actualizados
        val radioGroup: RadioGroup = view.findViewById(R.id.frutas_radgroup)
        val checkButton: Button = view.findViewById(R.id.btn_enviar)

        // Acción cuando se presiona el botón
        checkButton.setOnClickListener {
            val selectedOptionId = radioGroup.checkedRadioButtonId

            if (selectedOptionId != -1) {
                val selectedRadioButton: RadioButton = view.findViewById(selectedOptionId)

                // Verifica si la opción correcta (op_6) fue seleccionada
                if (selectedOptionId == R.id.op_6) {
                    Toast.makeText(requireContext(), "¡Bien hecho! Lo has encontrado", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Inténtalo de nuevo", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Por favor selecciona una opción", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
