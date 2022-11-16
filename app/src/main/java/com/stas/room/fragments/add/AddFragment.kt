package com.stas.room.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.get
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.stas.room.R
import com.stas.room.data.Name
import com.stas.room.data.NameViewModel
import com.stas.room.databinding.FragmentAddBinding


class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private lateinit var userViewMutableList: NameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.btnAdd.setOnClickListener {
            insertDataToDataBase()
        }
        userViewMutableList = ViewModelProvider(this)[NameViewModel::class.java]
        return view
    }

    private fun insertDataToDataBase() {
        val firstName = (R.id.et_add_first_name).toString()
        val secondName = (R.id.et_add_second_name).toString()
        val age = (R.id.et_add_age)

        if (inputCheck(firstName, secondName, Integer.parseInt(age.toString()))) {
            val name = Name(0,firstName,secondName, Integer.parseInt(age.toString()))
            userViewMutableList.addName(name)
            Toast.makeText(context,"ура!!!!!",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(context,"Ну что ты как не родной,",Toast.LENGTH_SHORT).show()
        }
    }
    private fun inputCheck(firstName: String, secondName: String, age: Int) : Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(secondName) && age != 1)
    }
}