package com.example.gestion_film.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.gestion_film.Model.User
import com.example.gestion_film.R
import com.example.gestion_film.databinding.FragmentLoginBinding
import com.example.gestion_film.utils.status
import javax.net.ssl.SSLEngineResult.Status


class LoginFragment :  BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    var idUser : Int = 0
    private val viewModel: FilmViewModel by viewModels()
    override fun init(view: View) {


    }

    @SuppressLint("SuspiciousIndentation")
    override fun listeners(view: View) {
        binding.apply {
            loginBtn.setOnClickListener {
                var emailInput = email.text.toString()
                var passwordInput = password.text.toString()
                var user = User(
                    idUser,emailInput,passwordInput
                )

                viewModel.login(user).observe(viewLifecycleOwner, Observer {
                            Log.d("email respons", user.toString())

                    when (it.status) {
                        status.LOADING ->showProgressBar()
                        status.ERROR -> showResponseError(it.message.toString())
                        status.SUCCESS -> {
                            Log.d("email respons", it.data?.email.toString())
                            val userId =  it.data?.id
                            val prefs = requireContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

                            if (userId != null) {
                                prefs.edit().putInt("userId", userId).apply()
                            }

                            binding.email.setText("")
                            binding.password.setText("")

                            val action = LoginFragmentDirections.actionLoginFragmentToListFilmFragment()
                            findNavController().navigate(action)
                            Toast.makeText(context, "welcome", Toast.LENGTH_SHORT).show()
                        }

                        }


                })
            }
        }
    }
}