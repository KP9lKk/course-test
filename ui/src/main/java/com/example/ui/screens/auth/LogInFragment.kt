package com.example.ui.screens.auth

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.ui.R
import com.example.ui.common.setClickableText
import com.example.ui.databinding.FragmentLogInBinding
import com.example.ui.screens.main.MainViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class LogInFragment : Fragment(R.layout.fragment_log_in) {

    val viewModel: LoginScreenViewModel by viewModel()
    val mainViewModel: MainViewModel by activityViewModel()
    var loginScreenBinding: FragmentLogInBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginScreenBinding = FragmentLogInBinding.bind(view)
        loginScreenBinding?.let {
            init(it)
        }

    }
    private fun init(binding: FragmentLogInBinding){
        binding.NavigateToRegistration.let {
            val text = ContextCompat.getString(requireContext(), R.string.login_to_registration)
            it.setClickableText(
                text = text,
                start = text.lastIndexOf(' ') + 1,
                end = text.length,
                color = ContextCompat.getColor(requireContext(), R.color.green)
            ){

            }
        }
        binding.OpenVkUrlButton.setOnClickListener {
            sendIntentWithUrl(viewModel.vkUrl)
        }
        binding.OpenOkUrlButton.setOnClickListener {
            sendIntentWithUrl(viewModel.okUrl)
        }
        binding.EmailEditText.doOnTextChanged { text, _, _, _ ->
            viewModel.setEmail(text.toString())
        }
        binding.PasswordEditText.doOnTextChanged { text, _, _, _ ->
            viewModel.setPassword(text.toString())
        }
        binding.LoginButton.setOnClickListener {
            mainViewModel.navigateToMain?.let {
                it()
            }
        }
        lifecycleScope.launch {
            viewModel.loginScreenStateFlow.collect{
                binding.LoginButton.isEnabled = it.buttonIsEnable
            }
        }
    }
    private fun sendIntentWithUrl(url: String){
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }
}