package com.example.todolist

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.todolist.room.AppDatabase
import com.example.todolist.room.TaskRepository
import com.example.todolist.room.entities.RoomTaskRepository
import kotlin.reflect.KProperty

object Repositories {

    private lateinit var applicationContext: Context

    // -- stuffs



    fun init(context: Context) {
        Log.d("got her", "got her")
        applicationContext = context
    }
}

