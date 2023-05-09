package com.example.todolist.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.*
import com.example.todolist.databinding.MainFragmentBinding


class MainFragment : Fragment() {

    lateinit var binding : MainFragmentBinding;
    private val args : MainFragmentArgs by navArgs()


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(layoutInflater, container, false)

        binding.apply {
            binding.rcView.layoutManager = LinearLayoutManager(context);
            binding.rcView.adapter = MAIN.adapter;
            binding.butAddTask.setOnClickListener() {
                MAIN.navController.navigate(R.id.action_mainFragment_to_editFragment);
            }

            val taskLabel = args.label;
            val taskInfo = args.info;

            if (taskLabel == "") {
                Log.d("kek", "kek");
            } else {
                MAIN.adapter.addTask(MyTask(taskLabel, taskInfo, false));
            }
        }

        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    interface MainFragmentInterface
    {
        fun onClick()
    }

}