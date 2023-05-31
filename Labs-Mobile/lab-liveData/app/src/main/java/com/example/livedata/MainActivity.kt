package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val model: Manager by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.nameTextView.text= model.currentName.value
        setContentView(binding.root)

        val nameObserver = Observer<String> { newName ->
           binding.nameTextView.text = newName
        }
         binding.incrementButton.setOnClickListener {
             model.currentName.value="heello nada"
         }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.currentName.observe(this, nameObserver)
    }
}