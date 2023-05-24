package com.example.lab_kotlinlivecoding.ui

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_kotlinlivecoding.R
import com.example.lab_kotlinlivecoding.classe.TaskEntry
import com.example.lab_kotlinlivecoding.classe.TaskRepository
import com.example.lab_kotlinlivecoding.databinding.FragmentFormBinding
import com.example.lab_kotlinlivecoding.databinding.FragmentListBinding


class FormFragment : Fragment() {

    companion object{
        val TASKid = "taskName"
    }
    private var _binding : FragmentFormBinding? = null
    private val binding get() = _binding!!
    private val taskRepository = TaskRepository()
    private lateinit var task : TaskEntry
    private var taskId =  0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            taskId = it.getInt(TASKid)
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Retrieve and inflate the layout for this fragment
        _binding = FragmentFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Ajouter
        if (taskId == 0) {
            this.task = taskRepository.newTask()
            binding.btnDelete.visibility = View.INVISIBLE
        }
        // Modifier
        else {
            this.task = taskRepository.findById(taskId!!)

        }

//  binding.apply : en utilise pour donner l'acces a view
        binding.apply {
            editTaskTitle.setText(task.title)
            spinner.setSelection(task.priority)
            btnSave.setOnClickListener {
                if (TextUtils.isEmpty(editTaskTitle.text)) {
                    Toast.makeText(context, "It's empty!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val taskTitle = editTaskTitle.text.toString()
                val priority = spinner.selectedItemPosition
                val taskEntry = TaskEntry(task.id, taskTitle, priority, task.time)
                taskRepository.save(taskEntry)
                Toast.makeText(context, "Saved!", Toast.LENGTH_SHORT).show()
                val action = FormFragmentDirections.actionFormFragmentToListFragment()
                view.findNavController().navigate(action)
            }
            btnDelete.setOnClickListener {
                taskRepository.delete(taskId!!)
                Toast.makeText(context, "Deleted!", Toast.LENGTH_SHORT).show()
                val action = FormFragmentDirections.actionFormFragmentToListFragment()
                view.findNavController().navigate(action)

            }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    }