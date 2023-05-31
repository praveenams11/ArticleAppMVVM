package com.pms.articleappmvvm.api

import com.pms.articleappmvvm.model.Root
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/svc/mostpopular/v2/emailed/7.json")
    suspend fun getPopularArticles(@Query("api-key") apiKey: String): Response<Root>
}