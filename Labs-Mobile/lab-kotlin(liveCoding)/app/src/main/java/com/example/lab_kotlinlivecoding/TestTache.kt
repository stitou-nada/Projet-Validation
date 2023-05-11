package com.example.lab_kotlinlivecoding

import com.example.lab_kotlinlivecoding.classe.TaskEntry
import com.example.lab_kotlinlivecoding.classe.TaskRepository

fun main(){
    println("hello nada")
    val  taskrepo= TaskRepository()
// Ajouter task
  val task = TaskEntry(0, "stitou",1 , 1234)
    taskrepo.save(task)
//    Afficher task

    val getAll= taskrepo.getAllTask()
    for(data in getAll){
        println(data.title)
    }

}