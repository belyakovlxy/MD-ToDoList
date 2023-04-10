package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todolist.databinding.ActivityTaskInfoBinding

class TaskInfo : AppCompatActivity() {
    private lateinit var binding: ActivityTaskInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        binding = ActivityTaskInfoBinding.inflate(layoutInflater);

        setContentView(binding.root);

        val item = intent.getSerializableExtra("info") as MyTask;

        binding.apply {
            taskLabelValue.text = item.name;
            taskInfoValue.text = item.info;
        }
    }
}