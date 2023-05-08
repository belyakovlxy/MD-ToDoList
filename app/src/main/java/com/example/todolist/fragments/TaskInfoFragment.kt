package com.example.todolist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.todolist.MAIN
import com.example.todolist.R
import com.example.todolist.databinding.EditFragmentBinding
import com.example.todolist.databinding.TaskInfoFragmentBinding

class TaskInfoFragment : Fragment() {
    lateinit var binding : TaskInfoFragmentBinding;
    private val args : TaskInfoFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TaskInfoFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            binding.taskLabelValue.text = args.label.toString()
            binding.taskInfoValue.text = args.info.toString()
            binding.closeButton.setOnClickListener() {
                MAIN.navController.navigate(R.id.action_taskInfoFragment_to_mainFragment);
            }

        }
    }
}