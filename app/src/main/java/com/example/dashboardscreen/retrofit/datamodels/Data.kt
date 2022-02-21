package com.example.dashboardscreen.retrofit.datamodels

data class Data(
    val created_on: String,
    val description: String,
    val feed_comments: String,
    val feed_like: String,
    val feed_recreation: String,
    val feed_share: String,
    val hashtag: List<Hashtag>,
    val id: String,
    val images: List<Image>,
    val is_like: Int,
    val is_recreated: String,
    val media: List<Any>,
    val time: String,
    val user_data: UserData,
    val user_id: String
)