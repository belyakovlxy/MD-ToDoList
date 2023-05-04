package com.example.todolist.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todolist.MAIN
import com.example.todolist.MyTask
import com.example.todolist.R
import com.example.todolist.databinding.EditFragmentBinding

class EditFragment : Fragment() {

    lateinit var binding : EditFragmentBinding;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EditFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root;
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            binding.buttonCancelAdding.setOnClickListener() {
                MAIN.navController.navigate(R.id.action_editFragment_to_mainFragment_byCancel);
            }
            binding.buttonApplyAdding.setOnClickListener() {
                val action = EditFragmentDirections.actionEditFragmentToMainFragmentByCancel(binding.taskLabel.text.toString(),binding.taskInfo.text.toString());
                MAIN.navController.navigate(action);
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}