package com.example.todolist.room

import androidx.room.*
import com.example.todolist.MyTask
import com.example.todolist.room.entities.TaskEntity

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks")
    fun getAllTasks() : List<TaskEntity>?

    @Query("UPDATE tasks SET is_done = :isDone WHERE name = :taskName")
    fun updateTask(taskName: String, isDone: Boolean)

    @Insert
    fun addTask(taskEntity : TaskEntity)

    @Query("DELETE FROM tasks WHERE name = :taskName")
    fun removeTask(taskName : String)

}