package com.pms.articleappmvvm.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pms.articleappmvvm.api.ApiService
import com.pms.articleappmvvm.api.RetrofitInstance
import com.pms.articleappmvvm.model.Articles
import kotlinx.coroutines.launch

class ArticleViewModel : ViewModel() {
    companion object {
        const val apiKey = "xibs45Z6Sbrft5RGyA6yJl4HNJmPGPGE"
    }
    var articleList: List<Articles> by mutableStateOf(listOf())
    var error: String by mutableStateOf("")

    fun getPopularArticles() {
        viewModelScope.launch {
            val apiService = RetrofitInstance.getRetrofitInstance().create(ApiService::class.java)
            val call = apiService.getPopularArticles(apiKey)
            try {
                articleList = call.body()!!.results
            } catch (e: Exception) {
                error = e.message.toString()
            }
        }
    }



}