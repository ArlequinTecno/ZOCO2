package com.arlequins.zoco.ui.signup

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.arlequins.zoco.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val signUpViewModel = ViewModelProvider(this)[SignUpViewModel::class.java]

        _binding = FragmentSignUpBinding.inflate(inflater, container, false)

        signUpViewModel.errorMsg.observe(viewLifecycleOwner){ msg ->
            showErrorMessage(msg)
        }
        signUpViewModel.registerSuccess.observe(viewLifecycleOwner){
            goToLogin()
        }

        with (binding){
            signUpButton.setOnClickListener {
                signUpViewModel.validateFields(
                    nameInputText.text.toString(),
                    emailInputText.text.toString(),
                    phoneInputText.text.toString(),
                    passwdInputText.text.toString(),
                    repasswdInputText.text.toString()
                )
            }
        }

        return binding.root
    }

    private fun showErrorMessage(msg: String?) {
        Toast.makeText(requireActivity(), msg, Toast.LENGTH_LONG).show()
    }

    private fun goToLogin(){
        findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToNavLogIn())
    }
    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }

}