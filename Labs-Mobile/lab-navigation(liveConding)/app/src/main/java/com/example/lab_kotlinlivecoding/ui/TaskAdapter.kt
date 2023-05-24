package com.example.lab_kotlinlivecoding.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_kotlinlivecoding.R
import com.example.lab_kotlinlivecoding.classe.TaskRepository
import java.text.SimpleDateFormat
import java.util.Locale

class TaskAdapter(navController: NavController):RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private val taskRepository = TaskRepository()
    private val navController = navController
    //    taskViewHolder : c'est une methode utilise pour declare les content d'un item
    class TaskViewHolder(private val ItemView:View):RecyclerView.ViewHolder(ItemView) {
         val title : TextView = ItemView.findViewById<Button>(R.id.taskTitle)
         val priority : TextView = ItemView.findViewById<Button>(R.id.taskPriority)
         val taskTime : TextView = ItemView.findViewById<Button>(R.id.taskTimestamp)
         val cardView : CardView = ItemView.findViewById(R.id.cardview)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        var layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_item,parent,false)
        return TaskViewHolder(layout)
    }

      override fun getItemCount(): Int {
        return taskRepository.getAllTask().size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = this.taskRepository.getAllTask()[position]
        holder.title.text = task.title

//        Afficher la priorité de la tâche en chaîne de caractère selon les valeurs enregistrés dans le fichier strings.xml
        val valueRoot = holder.itemView.context
        val getPriority = valueRoot.resources.getStringArray(R.array.priorities)
        holder.priority.text = getPriority[task.priority-1]

//        afficher la date de la tache correctment
        val formateur = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        holder.taskTime.text = formateur.format(task.time)
        holder.cardView.setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToFormFragment(taskName = task.id )
            navController.navigate(action)
       }
    }

}