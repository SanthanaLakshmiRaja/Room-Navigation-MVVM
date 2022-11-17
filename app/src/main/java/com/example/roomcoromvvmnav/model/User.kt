package com.example.roomcoromvvmnav.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "UserTable")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name="FirstName")
    val firstname:String,
    @ColumnInfo(name="LastName")
    val lastname:String,
    @ColumnInfo(name="Age")
    val age:Int
): Parcelable
