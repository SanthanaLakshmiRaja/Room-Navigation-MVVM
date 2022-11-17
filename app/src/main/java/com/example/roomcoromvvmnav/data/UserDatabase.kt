package com.example.roomcoromvvmnav.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomcoromvvmnav.model.User

@Database(entities=[User::class],version=1, exportSchema = false)
abstract class UserDatabase :RoomDatabase() {

    abstract fun userdao():UserDao



    companion object
    {
        @Volatile
        private var instance:UserDatabase?=null



fun getdatabase(context:Context):UserDatabase
{
  var tempInstance= instance
    if(tempInstance!=null)
    {
        return tempInstance
    }
   synchronized(this)
   {

     var INSTANCE= Room.databaseBuilder(context.applicationContext,
         UserDatabase::class.java,"userdatabase").build()

       instance=INSTANCE
        return INSTANCE

   }

}

    }









}