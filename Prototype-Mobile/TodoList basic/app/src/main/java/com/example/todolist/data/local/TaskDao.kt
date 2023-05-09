package com.example.todolist.data.local


class TaskDao {


    private var list_tasks : MutableList<TaskEntry> = mutableListOf<TaskEntry>()

    init {
        // Todo : add 10 tasks
        val t1 = TaskEntry(1,"Task1",1,System.currentTimeMillis())
        list_tasks.add(t1)
        list_tasks.add(t1)
    }



    fun insert(taskEntry: TaskEntry){

         list_tasks.add(taskEntry)
     }

     fun delete(taskEntry: TaskEntry){

     }

     fun update(taskEntry: TaskEntry){

     }


    fun getAllTasks(): MutableList<TaskEntry> {
        return list_tasks
    }


}