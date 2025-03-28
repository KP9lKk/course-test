package com.example.ui.common

import androidx.navigation.NavController
import androidx.navigation.createGraph
import androidx.navigation.fragment.fragment
import com.example.ui.screens.OnBoardingFragment
import com.example.ui.screens.auth.LogInFragment
import com.example.ui.screens.favorite.FavoriteScreenFragment
import com.example.ui.screens.home.HomeScreenFragment
import kotlinx.serialization.Serializable

class NavigationService(
    private val isFirstOpen: Boolean,
    private val navController: NavController
) {

    init {
        val startDestination: Any  = if (isFirstOpen) OnBoardingScreen else LogInScreen
        navController.graph = navController.createGraph(startDestination = startDestination){
            fragment<OnBoardingFragment, OnBoardingScreen>{}
            fragment<LogInFragment, LogInScreen>{}
            fragment<HomeScreenFragment, MainScreen>{}
            fragment<FavoriteScreenFragment, FavoriteScreen>()
        }
    }
    companion object Screens{
        @Serializable
        object OnBoardingScreen
        @Serializable
        object LogInScreen
        @Serializable
        object MainScreen
        @Serializable
        object FavoriteScreen
    }
}