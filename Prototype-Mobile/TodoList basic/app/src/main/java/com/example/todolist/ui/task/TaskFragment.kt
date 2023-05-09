package com.example.todolist.ui.task

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todolist.R
import com.example.todolist.data.TaskRepository
import com.example.todolist.databinding.FragmentTaskBinding


class TaskFragment : Fragment() {


    private lateinit var mAdapter: TaskAdapter


    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val taskRepository = TaskRepository()
        val binding = FragmentTaskBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this

        mAdapter = TaskAdapter(TaskClickListener { taskEntry ->
            findNavController().navigate(TaskFragmentDirections.actionTaskFragmentToUpdateFragment(taskEntry))
        })


        mAdapter.submitList(taskRepository.getAllTasks())


        binding?.apply {

            recyclerView.adapter = mAdapter

            // findNavController().navigate(R.id.action_taskFragment_to_addFragment)
            floatingActionButton.setOnClickListener {
                findNavController().navigate(R.id.action_taskFragment_to_addFragment)
            }
        }


        return binding.root
    }

}