package com.example.roomcoromvvmnav.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.roomcoromvvmnav.R

import com.example.roomcoromvvmnav.databinding.FragmentUpdateBinding
import com.example.roomcoromvvmnav.model.User
import com.example.roomcoromvvmnav.viewmodel.UserViewmodel


class UpdateFragment : Fragment() {


    private val args by navArgs<UpdateFragmentArgs>()

    lateinit var binding:FragmentUpdateBinding
    private lateinit var   userviewmodel: UserViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentUpdateBinding.inflate(inflater,container,false)


        userviewmodel= ViewModelProvider(this)[UserViewmodel::class.java]


        binding.firstNameUpdate.setText(args.currentUser.firstname)
        binding.lastNameUpdate.setText(args.currentUser.lastname)
        binding.ageUpdate.setText(args.currentUser.age.toString())

        binding.buttonUpdate.setOnClickListener {
            updateItem()
        }
          return binding.root
    }

   private fun updateItem()
    {
        val firstname=binding.firstNameUpdate.text.toString()
        val lastname=binding.lastNameUpdate.text.toString()
        val age= Integer.parseInt(binding.ageUpdate.text.toString())

        if(firstname.isNotEmpty() && lastname.isNotEmpty() && binding.ageUpdate.text.isNotEmpty())
        {
            //created user object
            val updateuser= User(args.currentUser.id,firstname,lastname,age)
            //add data to database
          userviewmodel.updateUser(updateuser)

            Toast.makeText(requireContext(),"Data updated sucessfully", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        else
        {
            Toast.makeText(requireContext(),"Please fill required fields", Toast.LENGTH_SHORT).show()
        }

    }


}