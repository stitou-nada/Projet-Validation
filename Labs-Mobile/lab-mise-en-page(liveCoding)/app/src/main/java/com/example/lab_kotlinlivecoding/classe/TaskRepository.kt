package com.example.lab_kotlinlivecoding.classe

class TaskRepository {
    val taskDAO = TaskDAO()
    fun getAllTask() = taskDAO.getAllTask()
    fun insert(taskEntry: TaskEntry)=taskDAO.insert(taskEntry)
    fun update(taskEntry: TaskEntry)=taskDAO.update(taskEntry)
    fun delete(id: Int)=taskDAO.delete(id)
    fun save(taskEntry: TaskEntry){
        if (taskEntry.id == 0){
            insert(taskEntry)
        }else{
            update(taskEntry)
        }
    }
}