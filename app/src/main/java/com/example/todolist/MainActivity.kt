package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding;
    private val adapter = MyTaskAdapter();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(R.layout.activity_main);
        init();
    }

    private fun init()
    {
        binding.apply {
            binding.rcView.layoutManager = LinearLayoutManager(this@MainActivity);
            binding.rcView.adapter = adapter;
        }
    }
}