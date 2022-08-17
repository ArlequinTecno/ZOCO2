package com.arlequins.zoco.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.arlequins.zoco.databinding.FragmentLogInBinding

class LogInFragment : Fragment() {
    private var _binding: FragmentLogInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        val logInViewModel = ViewModelProvider(this)[LogInViewModel::class.java]

        _binding = FragmentLogInBinding.inflate(inflater, container, false)

        binding.loginButton.setOnClickListener {
            goToLogin()
        }
        binding.loginToSignupTextView.setOnClickListener{
            findNavController().navigate(LogInFragmentDirections.actionNavLogInToSignUpFragment())
        }

        return binding.root
    }

    private fun goToLogin(){
        findNavController().navigate(LogInFragmentDirections.actionLogInFragmentToNavAllProducts())
    }
    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }

}