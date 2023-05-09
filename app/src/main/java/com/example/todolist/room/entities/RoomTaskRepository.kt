package com.example.todolist.room.entities

import android.database.sqlite.SQLiteConstraintException
import com.example.todolist.MyTask
import com.example.todolist.room.TaskDao
import com.example.todolist.room.TaskRepository

class RoomTaskRepository(
    private val taskDao : TaskDao
) : TaskRepository
{
    override fun addTask(task: MyTask) {
        val entity = TaskEntity.fromMyTask(task)
        taskDao.addTask(entity)
    }

    override fun removeTask(taskName: String) {
        taskDao.removeTask(taskName)
    }

    override fun updateIsDoneTask(task: MyTask) {
        taskDao.updateTask(task.name, task.isDone)
    }

    override fun getAllTasks(): List<MyTask> {
        val alltasks = taskDao.getAllTasks()
        if (alltasks != null)
        {
            return alltasks.map { taskEntity -> taskEntity.toMyTask() }
        }
        else
        {
            return listOf<MyTask>()
        }
    }

}