package com.stas.room.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.stas.room.R
import com.stas.room.data.User
import com.stas.room.data.UserViewModel
import com.stas.room.databinding.FragmentAddBinding


class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private lateinit var userViewMutableList: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.btnAdd.setOnClickListener {
            insertDataToDataBase()
        }
        userViewMutableList = ViewModelProvider(this)[UserViewModel::class.java]
        return view
    }

    private fun insertDataToDataBase() {
        val firstName  = binding.etAddFirstName.text.toString()
        val secondName = binding.etAddSecondName.text.toString()
        val age = binding.etAddAge.text
        if(checked(firstName,secondName,age)){
            val name =  User(0, firstName, secondName, Integer.parseInt(age.toString()))
            userViewMutableList.addName(name)
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
            Snackbar.make(binding.root, "Ура",Snackbar.LENGTH_LONG).show()
        }else{
            Snackbar.make(binding.root, "Ошибка",Snackbar.LENGTH_LONG).show()
        }

    }
    private fun checked(firstName : String,secondName : String,age : Editable) : Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(secondName) && age.isEmpty())
    }
}