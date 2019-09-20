package com.example.login_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.login_app.databinding.ActivityLoginBinding
import com.example.login_app.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var model: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       /* model = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main) as ActivityMainBinding
        model.setLogin(intent.getStringExtra("name"))
        binding.user = model
        binding.setLifecycleOwner(this)
        */
       // var name = intent.getStringExtra("name")
        textView.text="Добро пожаловать, " + intent.getStringExtra("name")

    }
}
