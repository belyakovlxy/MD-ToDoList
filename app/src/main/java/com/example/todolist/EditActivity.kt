package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todolist.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding;

    var index = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditBinding.inflate(layoutInflater);
        setContentView(binding.root);
        initButtons();
    }

    private fun initButtons() {
        binding.buttonApplyAdding.setOnClickListener() {
            val task =
                MyTask(index, binding.taskLabel.text.toString(), binding.taskInfo.text.toString());
            val editIntent = Intent().apply {
                putExtra("task", task);
            }
            setResult(RESULT_OK, editIntent);
            index++;
            finish();
        }

        binding.buttonCancelAdding.setOnClickListener() {
            finish();
        }
    }
}