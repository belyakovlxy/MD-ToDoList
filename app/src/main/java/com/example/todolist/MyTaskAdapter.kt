package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.TaskItemBinding

class MyTaskAdapter : RecyclerView.Adapter<MyTaskAdapter.MyTaskHolder>()
{
    val taskList = ArrayList<MyTask>();

    class MyTaskHolder(item : View) : RecyclerView.ViewHolder(item)
    {
        val binding = TaskItemBinding.bind(item);
        fun bind(task : MyTask)
        {
            binding.taskName.text = task.name;
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyTaskHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false);
        return MyTaskHolder(view);
    }

    override fun onBindViewHolder(holder: MyTaskHolder, position: Int)
    {
        holder.bind(taskList[position]);
    }

    override fun getItemCount(): Int
    {
        return taskList.size;
    }

    fun addTask(task : MyTask)
    {
        taskList.add(task);
        notifyDataSetChanged();
    }
}