package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.TaskItemBinding


class MyTaskAdapter(val listener : removeListener) : RecyclerView.Adapter<MyTaskAdapter.MyTaskHolder>()
{
    //var taskList = ArrayList<MyTask>()
    var taskList = ArrayList(MAIN.roomTaskRepository.getAllTasks());

    class MyTaskHolder(item : View) : RecyclerView.ViewHolder(item)
    {
        val binding = TaskItemBinding.bind(item);
        fun bind(task: MyTask, listener: removeListener)
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
        holder.bind(taskList.get(position), listener);
    }

    override fun getItemCount(): Int
    {
        return taskList.size;
    }

    fun addTask(task : MyTask)
    {
        taskList.add(task);
        MAIN.roomTaskRepository.addTask(task)
        notifyDataSetChanged();
    }


    fun removeTask(task : MyTask)
    {
        var position = taskList.indexOf(task);
        taskList.remove(task);
        MAIN.roomTaskRepository.removeTask(task.name)
        notifyItemRemoved(position);
    }

    interface removeListener
    {
        fun onClickDelete(task : MyTask);

        fun onClick(task : MyTask);

        fun onCheck(task : MyTask)
    }
}