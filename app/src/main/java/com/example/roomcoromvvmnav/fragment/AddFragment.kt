package com.example.roomcoromvvmnav.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomcoromvvmnav.R
import com.example.roomcoromvvmnav.viewmodel.UserViewmodel
import com.example.roomcoromvvmnav.model.User
import com.example.roomcoromvvmnav.databinding.FragmentAddBinding

class AddFragment : Fragment() {

  lateinit var binding: FragmentAddBinding
lateinit var userviewmodel: UserViewmodel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        binding=FragmentAddBinding.inflate(inflater,container,false)

        userviewmodel= ViewModelProvider(this)[UserViewmodel::class.java]

        binding.button.setOnClickListener {
             insertdata()
         }



        return binding.root
    }

    fun insertdata() {
        val firstname=binding.firstName.text.toString()
        val lastname=binding.lastName.text.toString()
        val age=binding.age.text

if(firstname.isNotEmpty() && lastname.isNotEmpty() && age.isNotEmpty())
      //  if(inputcheck(firstname,lastname,age))
{
    //created user object
     val user= User(0,firstname,lastname,Integer.parseInt(age.toString()))
    //add data to database
    userviewmodel.addUser(user)
    Toast.makeText(requireContext(),"Data inserted sucessfully",Toast.LENGTH_SHORT).show()
    findNavController().navigate(R.id.action_addFragment_to_listFragment)
}
else
{
    Toast.makeText(requireContext(),"Please fill required fields",Toast.LENGTH_SHORT).show()
}




    }
//    private fun inputcheck(firstname:String,lastname:String,age: Editable):Boolean
//    {
//     return !(TextUtils.isEmpty(firstname) && TextUtils.isEmpty(lastname) && age.isEmpty())
//    }


}