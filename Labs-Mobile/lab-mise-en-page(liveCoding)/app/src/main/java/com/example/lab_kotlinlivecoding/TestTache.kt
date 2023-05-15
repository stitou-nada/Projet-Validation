package com.example.lab_kotlinlivecoding

import com.example.lab_kotlinlivecoding.classe.TaskEntry
import com.example.lab_kotlinlivecoding.classe.TaskRepository

fun main(){
    val  taskrepo= TaskRepository()

// Ajouter task
    val task = TaskEntry(5, "butaina",1 , 1234)
    taskrepo.save(task)
//  Supprimer task
    taskrepo.delete(7)

// Afficher task

    val getAll= taskrepo.getAllTask()
    for(data in getAll){
        println(data.title)
    }

}