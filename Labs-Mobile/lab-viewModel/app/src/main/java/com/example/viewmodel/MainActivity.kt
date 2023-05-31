package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    private val scoreViewModel : ScoreViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val change = findViewById<Button>(R.id.button)
        change.setOnClickListener {
            scoreViewModel.increaseScore()
             updateScoreTextView()
        }
    }
    fun updateScoreTextView(){
        val score = findViewById<TextView>(R.id.score)
        val currentScore = scoreViewModel.getScore()
        score.text = "score : $currentScore"
    }
}