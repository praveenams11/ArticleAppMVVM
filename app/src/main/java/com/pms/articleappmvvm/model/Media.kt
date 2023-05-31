package com.pms.articleappmvvm.model

import com.google.gson.annotations.SerializedName


data class Media(
    val type: String,
    val subtype: String,
    val caption: String,
    val copyright: String,
    @SerializedName("approved_for_syndication")
    val approvedForSyndication: Long,
    @SerializedName("media-metadata")
    val mediaMetadata: List<MediaMetadata>,

)