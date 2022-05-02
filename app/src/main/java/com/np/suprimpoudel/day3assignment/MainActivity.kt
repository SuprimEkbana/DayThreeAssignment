package com.np.suprimpoudel.day3assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.np.suprimpoudel.day3assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding For MainActivity
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpNavigationController()

        setUpActionBarWithNavController()

        setUpBottomNavigationWithNavController()
    }

    private fun setUpNavigationController() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerMainActivity) as NavHostFragment
        navController = navHostFragment.navController
    }

    private fun setUpActionBarWithNavController() {
        NavigationUI.setupActionBarWithNavController(this, navController)
        AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController)
    }

    private fun setUpBottomNavigationWithNavController() {
        NavigationUI.setupWithNavController(binding.bottomNavigationActivityMain, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navController.handleDeepLink(intent)
    }
}