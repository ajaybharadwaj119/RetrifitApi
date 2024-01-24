package com.aj.retrofitapi.model

class BankRepository {
    private val createRetrofit= RetrofitInstance.bankEndPoint

    suspend fun getBankDetails(): BankModel{
        return createRetrofit.getBankModel()
    }

}