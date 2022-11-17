package com.example.roomcoromvvmnav.repository

import androidx.lifecycle.LiveData
import com.example.roomcoromvvmnav.model.User
import com.example.roomcoromvvmnav.data.UserDao

class UserRespository(private val userDao: UserDao){

    val readAlldata:LiveData<List<User>> = userDao.readalldata()

 suspend fun addUser(user: User)
{
    userDao.addUser(user)
}

suspend fun updateUser(user:User)
{
    userDao.updateUser(user)
}

    suspend fun deleteUser(user:User){
     userDao.deleteUser(user)
    }


}