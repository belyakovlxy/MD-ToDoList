package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.fragments.EditFragmentDirections
import com.example.todolist.fragments.MainFragment
import com.example.todolist.fragments.MainFragmentDirections

class MainActivity : AppCompatActivity(), MyTaskAdapter.removeListener {
    lateinit var binding : ActivityMainBinding;
    lateinit var navController : NavController;

    lateinit var adapter : MyTaskAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        MAIN = this;
        adapter = MyTaskAdapter(this);
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onClickDelete(task: MyTask) {
        adapter.removeTask(task);
    }

    override fun onClick(task: MyTask) {
        val action = MainFragmentDirections.actionMainFragmentToTaskInfoFragment(task.name.toString(), task.info.toString());
        navController.navigate(action)
    }

    override fun onCheck(task: MyTask) {
        if (task.isDone == true)
        {
            task.isDone = false;
        }
        else
        {
            task.isDone = true;
        }
    }


}