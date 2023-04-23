package com.example.todolist.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.EditActivity
import com.example.todolist.MyTask
import com.example.todolist.MyTaskAdapter
import com.example.todolist.R
import com.example.todolist.databinding.MainFragmentBinding

class MainFragment : Fragment(R.layout.main_fragment), MyTaskAdapter.removeListener {

    private var mainFramentBinding : MainFragmentBinding? = null;
    private val adapter = MyTaskAdapter(this);
    private var editLauncher : ActivityResultLauncher<Intent>? = null;


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var binding = MainFragmentBinding.bind(view);
        mainFramentBinding = binding;

        binding.apply {
            binding.rcView.layoutManager = LinearLayoutManager(this@MainFragment.context);
            binding.rcView.adapter = adapter;
            binding.butAddTask.setOnClickListener() {

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mainFramentBinding = null;
    }

    override fun onClickDelete(task: MyTask) {
        TODO("Not yet implemented")
    }

    override fun onClick(tasl: MyTask) {
        TODO("Not yet implemented")
    }
}