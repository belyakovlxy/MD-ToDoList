package com.example.todolist.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todolist.MyTask
import com.example.todolist.room.entities.TaskEntity

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks")
    suspend fun getAllTasks() : List<TaskEntity>?

    @Insert
    suspend fun addTask(taskEntity : TaskEntity)

    @Query("DELETE FROM tasks WHERE name = :taskName")
    suspend fun removeTask(taskName : String)

}