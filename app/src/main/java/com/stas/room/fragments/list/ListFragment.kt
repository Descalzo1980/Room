package com.stas.room.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.stas.room.R
import com.stas.room.data.UserViewModel
import com.stas.room.databinding.FragmentListBinding
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private lateinit var userViewModel : UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root

        val adapter = ListAdapter()
        val recyclerView = view.rv_users
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        userViewModel.readAllName.observe(viewLifecycleOwner, Observer {user ->
            adapter.setData(user)
        })

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return view
    }

}
