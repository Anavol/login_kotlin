package com.example.login_app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.login_app.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class LoginActivity : AppCompatActivity() {

    private lateinit var model: LoginViewModel //FIXME название переменной может привести к путанице, лучше назвать viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        val mainIntent = Intent(this, MainActivity::class.java)
        super.onCreate(savedInstanceState) //FIXME вызов метода родителя первой строкой, если нет необходимости вызвать этот метод позже
        setContentView(R.layout.activity_login)
        model = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView( //FIXME val binding = ActivityLoginBinding.inflate(layoutInflater)
            this, R.layout.activity_login)

        binding.viewModel = model
        binding.setLifecycleOwner(this)  //FIXME следи за подсказками студии раз уж пишем на котлине лучше использовать доступ через property, binding.lifecycleOwner = this

        loginButton.setOnClickListener { //FIXME в MVVM подходе это событие должно вызывать ф-ю вьюМодели, связь onClick с ф-ей ViewModel можно реализовать с помощью датабиндинга внутри которой будет вызвана ф-я модели либо навигатора
            if ((!model.getLogin().isNullOrEmpty()) && (!model.getPassword().isNullOrEmpty())) {
               imitateDelay(3000)
                startActivity(mainIntent.putExtra("name", model.getLogin()))
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

