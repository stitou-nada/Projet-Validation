package prototype.todolist

import android.provider.Settings
import prototype.todolist.data.TaskDao
import prototype.todolist.data.TaskEntry
import prototype.todolist.data.TaskRepository

fun main (){
    print("Programme de Test")
    val taskRepository = TaskRepository()
    // Ajouter une tâche
    val task = TaskEntry(1,"Task 1",1,System.currentTimeMillis())
    taskRepository.save(task);

    // Modifier une tâche
      var modifierTask = TaskEntry(1,"task nada",1,System.currentTimeMillis())
      taskRepository.save(modifierTask)

    // Suprimer une tâche
    taskRepository.delete(5)
    // Afficher les tâches
     var data = taskRepository.getAllTasks()
    for (task in data){
        println(task.title)
    }

}