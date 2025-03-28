package com.example.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.ui.R
import com.example.ui.databinding.FragmentOnBoardingBinding
import com.example.ui.screens.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel


class OnBoardingFragment : Fragment(R.layout.fragment_on_boarding) {
    val mainViewModel by activityViewModel<MainViewModel>()
    var onBoardingBinding: FragmentOnBoardingBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBoardingBinding = FragmentOnBoardingBinding.bind(view)
        onBoardingBinding?.let {
            bind(it)
        }
    }
    private fun bind(onBoardingBinding: FragmentOnBoardingBinding){
        onBoardingBinding.ContinueButton.setOnClickListener {
            mainViewModel.setIsFirstOpen()
            mainViewModel.navigateToLogin?.let {
                it()
            }
        }
    }
}