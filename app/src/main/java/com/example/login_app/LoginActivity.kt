package com.example.login_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.login_app.databinding.ActivityLoginBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext


class LoginActivity : AppCompatActivity() , LoginModel {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel = ViewModelProviders.of(this, viewModelFactory { LoginViewModel(this) }).get(LoginViewModel(this)::class.java)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(
           this, R.layout.activity_login)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(aClass: Class<T>):T = f() as T
        }

    override fun login(login: String, password: String): LoginResult {
        if ((!login.isNullOrEmpty()) && (!password.isNullOrEmpty())) {
            return LoginResult.Success(login = login)
        }
        else {
            return LoginResult.Error(message = "Поля не должны быть пустыми")
        }
    }

    override fun load(login: String)  {
        val mainIntent = Intent(this, MainActivity::class.java)
            GlobalScope.async {
                delay(3000)
                startActivity(mainIntent.putExtra("name", login))
            }
    }
}

