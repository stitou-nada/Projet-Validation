package com.example.lab_kotlinlivecoding.classe

class TaskDAO {

    companion object {
        var count = 0
        private val list : MutableList<TaskEntry> = mutableListOf<TaskEntry>()
        init{

            for (i in 1..10) {
                val task = TaskEntry(++count, title = "nada$i", priority = 1, time = 1234)
                list.add(task)
            }
        }

    }
    fun getAllTask(): MutableList<TaskEntry> {
        return TaskDAO.list
    }

    fun insert(taskEntry: TaskEntry) {
        list.add(taskEntry)
    }
    fun findIndexById(Id:Int): Int? {
    val findId = list.find { it.id ==Id }

            return findId!!.id


    }
    fun update(taskEntry: TaskEntry) {
     val findIndex = findIndexById(taskEntry.id)
       list[findIndex!!-1] = taskEntry
    }

    fun delete(Id: Int) {
         val deleteTask = list.removeAt(Id-1)
    }


}