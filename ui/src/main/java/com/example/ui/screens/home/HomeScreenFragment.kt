package com.example.ui.screens.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.ui.R
import com.example.ui.databinding.FragmentHomeScreenBinding
import com.example.ui.screens.home.adapter.CourseAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {
    private val screenViewModel: HomeScreenViewModel by viewModel()
    private var homeScreenBinding: FragmentHomeScreenBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeScreenBinding = FragmentHomeScreenBinding.bind(view)
        screenViewModel.getCourse()
        val adapter = CourseAdapter{
            screenViewModel.moveToFavorite(it)
        }
        homeScreenBinding?.SortedByPublishDate?.setOnClickListener {
            screenViewModel.sortedByPublishDate()
        }
        homeScreenBinding?.CoursesRecyclerView?.adapter = adapter
        lifecycleScope.launch {
            screenViewModel.homeScreenState.collect{
               adapter.submitList(it.courses)
            }
        }
    }
}