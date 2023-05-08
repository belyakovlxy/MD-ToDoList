package com.example.todolist.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todolist.MyTask

@Entity(
    tableName = "tasks"
)
data class TaskEntity (
@PrimaryKey  (autoGenerate = true)  val id: Long,
    val name: String,
    val info: String,
@ColumnInfo (name = "is_done") var isDone : Boolean
        ){
    fun toMyTask() : MyTask = MyTask(
        name = name,
        info = info,
        isDone = isDone
    )

    companion object {
        fun fromMyTask(myTask : MyTask) : TaskEntity = TaskEntity(
            id = 0,
            name = myTask.name,
            info = myTask.info,
            isDone = myTask.isDone
        )
    }
}