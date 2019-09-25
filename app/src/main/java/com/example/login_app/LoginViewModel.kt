package com.example.login_app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel(loginFunction: (login: String, password: String) -> (Unit)): ViewModel() {
     val loginFunction = loginFunction
     var login = MutableLiveData<String>()
          .apply {
               value = ""
          }
     var password = MutableLiveData<String>()
          .apply {
               value = ""
          }
     fun onClickLogin(){
               loginFunction(login.value.toString(), password.value.toString())
     }
}