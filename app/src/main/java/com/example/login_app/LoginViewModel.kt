package com.example.login_app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//FIXME убрать лишние пустые строки
class LoginViewModel: ViewModel() {
     var user = MutableLiveData<User>()  //FIXME не усложняй себе жизнь вместо поля с типом User добавь два поля login, password с типом MutableLiveData<String>
    //FIXME расскоментируй удали init посмотри что поулчится
//         .apply {
//         value = User("","")
//     }
     init {
         user.value = User("","") //FIXME можно обойтись без init
     }

    //FIXME эти функции не нужны, используй двусторонний дата биндинг
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

    //FIXME добавь ф-ю onClickLogin и свяжи ее вызов с нажатием кнопки "Войти"
    //создай интерфейс LoginModel с методом login(login:String, password:String)
    //реализовать его в LoginActivity
    //передать его реализацию в конструктор вью модели
    //и использовать в ф-ии onClickLogin
}

