package com.example.login_app

import retrofit2.http.Query

object SearchModel {
    data class Result(val query: Query)
    data class Query(val search: Search)
    data class Search(val item: Array<String>)
}