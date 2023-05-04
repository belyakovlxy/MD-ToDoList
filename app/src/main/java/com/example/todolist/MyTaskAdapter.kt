package com.example.todolist

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.TaskItemBinding
import kotlinx.parcelize.Parcelize


class MyTaskAdapter(val listener : removeListener) : RecyclerView.Adapter<MyTaskAdapter.MyTaskHolder>()
{
    var taskList = ArrayList<MyTask>();

    class MyTaskHolder(item : View) : RecyclerView.ViewHolder(item)
    {
        val binding = TaskItemBinding.bind(item);
        fun bind(task : MyTask, listener: removeListener)
        {
            binding.taskName.text = task.name;
            binding.taskCheckBox.setChecked(task.isDone)
            binding.buttonDeleteTask.setOnClickListener() {
                listener.onClickDelete(task);
            }
            binding.taskCard.setOnClickListener() {
                listener.onClick(task);
            }
            binding.taskCheckBox.setOnClickListener() {
                listener.onCheck(task)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyTaskHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false);
        return MyTaskHolder(view);
    }

    override fun onBindViewHolder(holder: MyTaskHolder, position: Int)
    {
        holder.bind(taskList[position], listener);
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


    fun removeTask(task : MyTask)
    {
        var position = taskList.indexOf(task);
        taskList.remove(task);
        notifyItemRemoved(position);
    }

    interface removeListener
    {
        fun onClickDelete(task : MyTask);

        fun onClick(task : MyTask);

        fun onCheck(task : MyTask)
    }
}