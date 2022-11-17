package com.example.roomcoromvvmnav.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomcoromvvmnav.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user:User)

    @Delete
    suspend fun deleteUser(user:User)

    @Query("SELECT * FROM UserTable ORDER BY id ASC")
    fun readalldata():LiveData<List<User>>





}