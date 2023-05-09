package com.example.todolist.data.local


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todolist.util.Constants
import kotlinx.parcelize.Parcelize


@Parcelize
data class TaskEntry(
    var id: Int,
    var title: String,
    var priority: Int,
    var timestamp: Long

    ) : Parcelable

