package com.example.login_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.login_app.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*
import android.widget.Toast
import kotlinx.coroutines.*


class LoginActivity : AppCompatActivity() {

    private lateinit var model: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        val mainIntent = Intent(this, MainActivity::class.java)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        model = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_login
        ) as ActivityLoginBinding

        binding.user = model
        binding.setLifecycleOwner(this)

        loginButton.setOnClickListener {

            if ((model.login.value.toString() != "null") && (model.password.value.toString() != "null")) {

               imitateDelay(3000)
                startActivity(mainIntent.putExtra("name", model.login.value.toString()))
            }
            else {
                val toast = Toast.makeText(
                    applicationContext,
                    "Поля не должны быть пустыми", Toast.LENGTH_SHORT
                )
                toast.show()
            }

        }
    }
    private fun imitateDelay(time: Long) = runBlocking {
        launch {
            delay(time)
        }
    }
}

