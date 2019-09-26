package com.example.login_app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class LoginViewModel(loginModel: LoginModel): ViewModel() {
     val loginModel = loginModel
     var login = MutableLiveData<String>()
          .apply {
               value = ""
          }
     var password = MutableLiveData<String>()
          .apply {
               value = ""
          }
     var isLoading = MutableLiveData<Boolean>()
          .apply {
          value = false
     }
     var errorMessage = MutableLiveData<String>()
          .apply {
              value =""
            }

     fun onClickLogin(){

          var result = loginModel.login(login.value.toString(), password.value.toString())
          if (result is LoginResult.Error){
            errorMessage.value = result.message

          }
          else
              if (result is LoginResult.Success){
                  errorMessage.value = ""
                  isLoading.value = true
                  GlobalScope.launch(Dispatchers.Main) {
                      loginModel.load(result.login)
                      isLoading.value = false
                      loginModel.startNew(result.login)
                      }
              }
     }
}