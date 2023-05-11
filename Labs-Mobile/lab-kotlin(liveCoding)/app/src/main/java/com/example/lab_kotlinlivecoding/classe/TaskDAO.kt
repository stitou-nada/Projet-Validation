package com.example.lab_kotlinlivecoding.classe

class TaskDAO {

    companion object {
        var count = 0
        private val list : MutableList<TaskEntry> = mutableListOf<TaskEntry>()
        init{

            for (i in 1..10) {
                val task = TaskEntry(++count, title = "$i", priority = 1, time = 1234)
                list.add(task)
            }
        }

    }
    fun getAllTask(): MutableList<TaskEntry> {
        return TaskDAO.list
    }
}