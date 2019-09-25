package com.example.login_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.login_app.databinding.ActivityLoginBinding
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.*


class LoginActivity : AppCompatActivity() , LoginModel {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel = ViewModelProviders.of(this, viewModelFactory { LoginViewModel(::login) }).get(LoginViewModel(::login)::class.java)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(
           this, R.layout.activity_login)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(aClass: Class<T>):T = f() as T
        }


    override fun login(login: String, password: String) {
        if ((!login.isNullOrEmpty()) && (!password.isNullOrEmpty())) {
            imitateDelay(3000)
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent.putExtra("name", login))
        }
        else {
            val toast = Toast.makeText(
                applicationContext,
                "Поля не должны быть пустыми", Toast.LENGTH_SHORT
            )
            toast.show()
        }
    }
    private fun imitateDelay(time: Long) = runBlocking {
        launch {
            delay(time)
        }
    }
}

