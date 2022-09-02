package com.example.fitnessshop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fitnessshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        navController = navHostFragment.findNavController()

          appBarConfiguration = AppBarConfiguration(
               setOf(
                   R.id.home,
                   R.id.shop,
                   R.id.video,
                   R.id.categories,
                   R.id.profile
               )
           )

           setupActionBarWithNavController(navController)
           binding.bottomNav.setupWithNavController(navController)

       }

       override fun onSupportNavigateUp(): Boolean {
           return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}