package com.example.todolist.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.todolist.R
import com.example.todolist.databinding.EditFragmentBinding

class EditFragment : Fragment(R.layout.edit_fragment) {

    private var editFragmentBinding : EditFragmentBinding? = null;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var binding = EditFragmentBinding.bind(view);
        editFragmentBinding = binding;
    }

    override fun onDestroyView() {
        super.onDestroyView()
        editFragmentBinding = null;
    }

}