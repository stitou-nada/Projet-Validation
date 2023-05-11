package com.example.lab_kotlinlivecoding

import com.example.lab_kotlinlivecoding.classe.TaskRepository

fun main(){
    println("hello nada")
// Ajouter task

//    Afficher task
    val  taskrepo= TaskRepository()
    val getAll= taskrepo.getAllTask()
    for(data in getAll){
        println(data.title)
    }

}