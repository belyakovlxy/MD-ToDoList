package com.example.todolist.room

import com.example.todolist.MyTask

interface TaskRepository {

    fun addTask(task : MyTask)

    fun removeTask(taskName : String)

    fun updateIsDoneTask(task : MyTask)

    fun  getAllTasks() : List<MyTask?>?
}