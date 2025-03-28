package com.example.ui.screens.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.ui.R
import com.example.ui.databinding.FragmentFavoriteScreenBinding
import com.example.ui.databinding.FragmentHomeScreenBinding
import com.example.ui.screens.home.HomeScreenViewModel
import com.example.ui.screens.home.adapter.CourseAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavoriteScreenFragment : Fragment(R.layout.fragment_favorite_screen) {
    private val screenViewModel: FavoriteScreenViewModel by viewModel()
    private var homeScreenBinding: FragmentFavoriteScreenBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeScreenBinding = FragmentFavoriteScreenBinding.bind(view)
        val adapter = CourseAdapter{
            screenViewModel.moveToFavorite(it)
        }

        homeScreenBinding?.CoursesRecyclerView?.adapter = adapter
        lifecycleScope.launch {
            screenViewModel.favoriteScreenState.collect{
                adapter.submitList(it.courses)
            }
        }
    }
}