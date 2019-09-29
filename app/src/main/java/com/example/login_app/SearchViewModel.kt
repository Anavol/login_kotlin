package com.example.login_app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel: ViewModel() {
    var welcome = MutableLiveData<String>()
        .apply {
            value = ""
        }
    var searchQuery = MutableLiveData<String>()
        .apply {
            value = ""
        }
    var searchResponse = MutableLiveData<String>()
        .apply {
            value = ""
        }
}