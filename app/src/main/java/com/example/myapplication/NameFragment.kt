package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.databinding.FragmentNameBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NameFragment : Fragment() {
    private lateinit var binding : FragmentNameBinding

    private var saldo = 0

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("Bienvenido(a) a Banco Hurtado: ")
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNameBinding.inflate(layoutInflater, container, false)
        binding.bienvenidatxt.text= "Bienvenido a Banco Hurtado, $param1"

        binding.okbutton.setOnClickListener{
            when (binding.radiogroup.checkedRadioButtonId) {
                R.id.versaldoradioButton ->
                    binding.montotxt.setText(saldo.toString())
                R.id.depositarradioButton-> ingresarSaldo()
                R.id.girarradioButton-> retirarMonto()
                R.id.salirradioButton-> finish()
            }
        }

        return binding.root
    }

    fun ingresarSaldo(){
        saldo += binding.montotxt.text.toString().toInt()
        Toast.makeText(context, "Su saldo ha sido actualizado correctamente", Toast.LENGTH_LONG).show()

    }

    fun retirarMonto(){
        saldo-= binding.montotxt.text.toString().toInt()
        Toast.makeText(context, "El retiro ha sido realizado correctamente", Toast.LENGTH_LONG).show()
    }

    fun finish(){

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NameFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NameFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}