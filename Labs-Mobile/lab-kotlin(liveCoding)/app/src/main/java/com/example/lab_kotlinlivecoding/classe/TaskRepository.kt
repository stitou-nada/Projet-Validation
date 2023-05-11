package com.example.lab_kotlinlivecoding.classe

class TaskRepository {
    val taskDAO = TaskDAO()
    fun getAllTask() = taskDAO.getAllTask()
}