package com.example.ui

import android.os.Bundle
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isGone
import androidx.navigation.fragment.NavHostFragment
import com.example.ui.common.NavigationService
import com.example.ui.databinding.ActivityMainBinding
import com.example.ui.screens.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class  MainActivity : AppCompatActivity() {
    val mainViewModel:MainViewModel by viewModel()
    var mainActivityMainBinding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityMainBinding?.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        NavigationService(mainViewModel.settings.value.isFirstOpen, navController)
        mainViewModel.navigateToMain = {
            navController.navigate(NavigationService.Screens.MainScreen)
            mainActivityMainBinding?.bottomNavigation?.isGone = false
        }
        mainViewModel.navigateToLogin = {
            navController.navigate(NavigationService.Screens.LogInScreen)
        }

        mainActivityMainBinding?.bottomNavigation?.setOnItemSelectedListener {
            when(it.itemId){
                R.id.main_action -> {
                    navController.navigate(NavigationService.Screens.MainScreen)
                    return@setOnItemSelectedListener true
                }
                R.id.favorite_action -> {
                    navController.navigate(NavigationService.Screens.FavoriteScreen)
                    return@setOnItemSelectedListener true
                }
                else -> {

                }
            }
            return@setOnItemSelectedListener false
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.dark))
            window.decorView.windowInsetsController?.setSystemBarsAppearance(0, APPEARANCE_LIGHT_STATUS_BARS)
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
