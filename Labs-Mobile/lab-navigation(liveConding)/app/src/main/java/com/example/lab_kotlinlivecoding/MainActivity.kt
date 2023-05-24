package com.example.lab_kotlinlivecoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_kotlinlivecoding.databinding.ActivityMainBinding
import com.example.lab_kotlinlivecoding.ui.TaskAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding: il lier layout avec data source
//        inflate : utilise pour convertire xml a view
        var binding = ActivityMainBinding.inflate(layoutInflater)
//        en utilise pour faire set a layout pour activitiy
        setContentView(binding.root)

//     en specifier navigation (navFragment)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}