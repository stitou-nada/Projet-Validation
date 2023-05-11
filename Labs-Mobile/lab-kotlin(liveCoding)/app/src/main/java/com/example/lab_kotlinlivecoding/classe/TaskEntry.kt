package com.example.lab_kotlinlivecoding.classe

data class TaskEntry(
    val id:Int,
    val title:String,
    val priority:Int,
    val time:Long?
)