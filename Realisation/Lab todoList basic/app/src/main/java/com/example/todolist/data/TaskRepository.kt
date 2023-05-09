package com.example.todolist.data

import com.example.todolist.data.local.TaskDao
import com.example.todolist.data.local.TaskEntry

class TaskRepository () {


    private val taskDao = TaskDao()

    fun insert(taskEntry: TaskEntry) = taskDao.insert(taskEntry)

     fun updateData(taskEntry: TaskEntry) = taskDao.update(taskEntry)

     fun deleteItem(taskEntry: TaskEntry) = taskDao.delete(taskEntry)


    fun getAllTasks() = taskDao.getAllTasks()

}