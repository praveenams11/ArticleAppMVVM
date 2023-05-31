package com.pms.articleappmvvm.model

import com.google.gson.annotations.SerializedName


data class Root(
    val status: String,
    val copyright: String,
    @SerializedName("num_results")
    val numResults: Long,
    val results: List<Articles>,
)