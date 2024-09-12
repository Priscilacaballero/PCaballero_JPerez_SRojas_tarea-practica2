package com.example.demo_ui_exa_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.demo_ui_exa_1.R

class FragmentOption8 : Fragment() {

    private lateinit var guestList: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_option8, container, false)

        val guestNameEditText = view.findViewById<EditText>(R.id.guestNameEditText)
        val addGuestButton = view.findViewById<Button>(R.id.btn_agregarinv)
        listView = view.findViewById(R.id.lv_invitados)

        // Inicializar la lista de invitados y el adaptador
        guestList = ArrayList()
        adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_single_choice, guestList)
        listView.adapter = adapter
        listView.choiceMode = ListView.CHOICE_MODE_SINGLE

        // Agregar invitado
        addGuestButton.setOnClickListener {
            val guestName = guestNameEditText.text.toString().trim()
            if (guestName.isNotEmpty()) {
                guestList.add(guestName)
                adapter.notifyDataSetChanged()
                guestNameEditText.text.clear()
            } else {
                Toast.makeText(requireContext(), "Por favor, ingresa un nombre", Toast.LENGTH_SHORT).show()
            }
        }

        // Eliminar invitado
        val removeGuestButton = view.findViewById<Button>(R.id.btn_eliminarinv)
        removeGuestButton.setOnClickListener {
            val position = listView.checkedItemPosition
            if (position != ListView.INVALID_POSITION) {
                guestList.removeAt(position)
                adapter.notifyDataSetChanged()
                listView.clearChoices()
            } else {
                Toast.makeText(requireContext(), "Por favor, selecciona un invitado para eliminar", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
