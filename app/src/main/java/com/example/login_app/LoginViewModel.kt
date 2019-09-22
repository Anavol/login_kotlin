package com.example.login_app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class LoginViewModel: ViewModel() {
     var user = MutableLiveData<User>()
     init {
         user.value = User("","")
     }
     fun getLogin(): String?{
          return user.value?.login
     }
     fun setLogin(newLogin: String): String?{
          user.value?.login = newLogin
          return user.value?.login
     }
     fun getPassword(): String?{
          return user.value?.password
     }
     fun setPassword(newPass: String): String?{
          user.value?.password = newPass
          return user.value?.password
     }



}