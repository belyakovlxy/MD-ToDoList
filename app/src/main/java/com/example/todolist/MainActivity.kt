package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyTaskAdapter.removeListener {
    lateinit var binding : ActivityMainBinding;
    private val adapter = MyTaskAdapter(this);
    private var editLauncher : ActivityResultLauncher<Intent>? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);
        init();
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK)
            {
                adapter.addTask(it.data?.getSerializableExtra("task") as MyTask)
            }
        }
    }

    private fun init()
    {
        binding.apply {
            binding.rcView.layoutManager = LinearLayoutManager(this@MainActivity);
            binding.rcView.adapter = adapter;
            binding.butAddTask.setOnClickListener() {
                editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java));
            }
        }
    }

    override fun onClick(task: MyTask) {
        adapter.removeTask(task);
    }
}