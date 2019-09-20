package com.example.login_app

import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*
import androidx.databinding.ObservableField




class User (): BaseObservable() {
  /*  private lateinit var login: String
    private lateinit var  password: String

    fun getlogin(): String? {
        return login
    }

    fun setlogin(login: String) {
        this.login = login
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.)
    }

    fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid)
    }
    */
   
   /* var login: String = ""
        set(value) {
            field = value
            setChanged()
            notifyObservers(field)
          //  setChangedAndNotify("login")
        }

    var password: String = ""
        set(value) {
            field = value
            setChanged()
            notifyObservers(field)
          //  setChangedAndNotify("password")
        }

    private lateinit var login: String
    private lateinit var password: String


    fun getStrLogin(): String {
        return strLogin
    }

    fun getStrPassword(): String {
        return strPassword
    }

    fun setStrLogin(newLogin: String){
        strLogin = newLogin
    }

    fun setStrPassword(newPass: String) {
        strPassword = newPass
    }
    */


}