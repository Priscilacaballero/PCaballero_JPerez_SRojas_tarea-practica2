package com.example.demo_ui_exa_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.*

class FragmentOption7 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_option7, container, false)

        val datePicker = view.findViewById<DatePicker>(R.id.datePicker)
        val calculateButton = view.findViewById<Button>(R.id.btn_calcularedad)
        val ageTextView = view.findViewById<TextView>(R.id.txt_edad)

        calculateButton.setOnClickListener {
            val day = datePicker.dayOfMonth
            val month = datePicker.month
            val year = datePicker.year

            val birthdayCalendar = Calendar.getInstance()
            birthdayCalendar.set(year, month, day)

            val today = Calendar.getInstance()

            var age = today.get(Calendar.YEAR) - birthdayCalendar.get(Calendar.YEAR)

            // Si aún no ha cumplido años este año, resta 1
            if (today.get(Calendar.DAY_OF_YEAR) < birthdayCalendar.get(Calendar.DAY_OF_YEAR)) {
                age--
            }

            // Mostrar la edad calculada en el TextView
            ageTextView.text = "Edad: $age años"
        }

        return view
    }
}
