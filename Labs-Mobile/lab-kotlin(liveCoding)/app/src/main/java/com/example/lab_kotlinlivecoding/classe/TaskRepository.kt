package com.example.lab_kotlinlivecoding.classe

class TaskRepository {
    val taskDAO = TaskDAO()
    fun getAllTask() = taskDAO.getAllTask()
    fun insert(taskEntry: TaskEntry)=taskDAO.insert(taskEntry)

    fun save(taskEntry: TaskEntry){
        if (taskEntry.id == 0){
            insert(taskEntry)
        }
    }
}