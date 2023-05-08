package com.example.todolist.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.room.entities.TaskEntity

@Database(
    version = 1,
    entities = [
        TaskEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase ()
{
    abstract fun getTaskDao() : TaskDao
}