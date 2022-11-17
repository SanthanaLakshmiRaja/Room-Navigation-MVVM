package com.example.roomcoromvvmnav.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomcoromvvmnav.R
import com.example.roomcoromvvmnav.viewmodel.UserViewmodel
import com.example.roomcoromvvmnav.databinding.FragmentListBinding
import com.example.roomcoromvvmnav.model.User

class ListFragment : Fragment() {

  private var _binding: FragmentListBinding?=null
    private val binding get() = _binding!!
    lateinit var listviewmodel : UserViewmodel
    private lateinit var listadapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listadapter = ListAdapter()
        listviewmodel = ViewModelProvider(this)[UserViewmodel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    //inflate the layout for the fragment
      _binding=FragmentListBinding.inflate(inflater,container,false)

        binding.addActionButton.setOnClickListener{

            findNavController().navigate(R.id.action_listFragment_to_addFragment)

        }
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        observeCategories()
        setOnClickMaterialCardView()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun setUpRecyclerView() {
        binding.recyclerView.adapter = listadapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())


    }
    private fun observeCategories() {
        listviewmodel.readalldata.observe(viewLifecycleOwner,Observer{ user->

         listadapter.setdata(user)
        })

    }

    private fun setOnClickMaterialCardView() {

      listadapter.setOnClickMaterialCardView(object :ListAdapter.OnClickMaterialCardView {

            override fun onClick(user:User) {
                listviewmodel.deleteUser(user)

                Toast.makeText(requireContext(), "${user.id} Deleted", Toast.LENGTH_LONG).show()


            }

        })

    }
}