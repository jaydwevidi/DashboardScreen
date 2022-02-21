package com.example.dashboardscreen.retrofit.functionality

import com.example.dashboardscreen.retrofit.datamodels.UserIDToSend
import com.example.dashboardscreen.retrofit.datamodels.ViewFeedResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface GetFeedInterface {


    @POST(".")
    suspend fun addToFeed (
        @Body userID : UserIDToSend
    ) : Response<ViewFeedResponse>
}