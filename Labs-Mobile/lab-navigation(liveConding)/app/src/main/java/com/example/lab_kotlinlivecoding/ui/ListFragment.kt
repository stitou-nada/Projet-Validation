package com.example.lab_kotlinlivecoding.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_kotlinlivecoding.R
import com.example.lab_kotlinlivecoding.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private var _binding : FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recycleView : RecyclerView
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Retrieve and inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycleView = binding.recyclerView
        this.taskAdapter = TaskAdapter(view.findNavController())
//  binding.apply : en utilise pour donner l'acces a view
    binding.apply {
//  layoutManager : c'est responsable de position d'un item dans recycelview
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = taskAdapter
        floatingActionButton.setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToFormFragment(taskName = 0 )
            view.findNavController().navigate(action)
        }

    }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

}