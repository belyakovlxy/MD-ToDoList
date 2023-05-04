package com.example.todolist

import android.os.Parcel
import android.os.Parcelable

data class MyTask(val name: String, val info: String, var isDone : Boolean)
{
}
