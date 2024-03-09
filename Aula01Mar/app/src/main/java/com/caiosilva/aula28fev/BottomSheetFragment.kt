package com.caiosilva.aula28fev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.caiosilva.aula28fev.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetBinding.inflate(inflater)

        setupListView()
        setupSpinner()

        return binding.root
    }

    private fun setupSpinner() {
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            lista
        )

        binding.spinnerBottomSheet.adapter = adapter
        binding.spinnerBottomSheet.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(requireContext(), lista[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                println("Não selecionou nada.")
            }
        }
    }

    private fun setupListView() {
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            lista
        )

        binding.listViewBottomSheet.adapter = adapter
    }

    companion object {
        private var lista: List<String> = listOf()

        fun newInstance(lista: List<String>): BottomSheetFragment {
            this.lista = lista

            return BottomSheetFragment()
        }
    }
}