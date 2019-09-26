package com.example.login_app

interface LoginModel {
    fun login(login: String, password: String): LoginResult
    suspend fun load(login: String)
    fun startNew(login: String)
}

    sealed class LoginResult {
        data class Success(val login: String) : LoginResult()
        data class Error(val message: String, val cause: Exception? = null) : LoginResult()
    }


