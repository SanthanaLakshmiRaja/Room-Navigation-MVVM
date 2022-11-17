package com.example.roomcoromvvmnav.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomcoromvvmnav.model.User
import com.example.roomcoromvvmnav.data.UserDatabase
import com.example.roomcoromvvmnav.repository.UserRespository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewmodel(application: Application):AndroidViewModel(application) {

   val readalldata : LiveData<List<User>>

  private val repository: UserRespository


    init
    {
        val userDao=UserDatabase.getdatabase(application).userdao()

        repository= UserRespository(userDao)
        readalldata=repository.readAlldata
    }


fun addUser(user: User) {
    viewModelScope.launch(Dispatchers.IO) {
        repository.addUser(user)
    }

}
    fun updateUser(user:User)
    {
        viewModelScope.launch(Dispatchers.IO){
            repository.updateUser(user)
        }
    }
    fun deleteUser (user:User) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteUser(user)
    }









}