package com.aj.retrofitapi.model

import retrofit2.http.GET

interface BankEndPoint {
    @GET("entries")
    suspend fun getBankModel(): BankModel
}