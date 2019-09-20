package com.example.login_app

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class LoginViewModel2(user: User): ViewModel() {


    fun setLogin(newLogin: String):LiveData<String>{
        login.setValue(newLogin)
        return login
    }

    fun setPassword(newPassword: String):LiveData<String>{
        password.setValue(newPassword)
        return password

    }
    @Bindable
    fun getLogin(): LiveData<String> {
        return login
    }
    @Bindable
    fun getPassword(): LiveData<String> {
        return password
    }
}

//class LoginViewModel():ViewModel() {
 //   var login = MutableLiveData<String>()
  //  var password = MutableLiveData<String>()
  /*  private var user = MutableLiveData<User>()

    fun getUser(): MutableLiveData<User> {

        if (user == null) {
            user = MutableLiveData<User>()
        }
        return user

    }

    fun setUser(newLog: String, newPas: String) {
        val loginUser = User(newLog, newPas)
        user.setValue(loginUser)

    }
}*/