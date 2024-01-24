package com.aj.retrofitapi.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aj.retrofitapi.model.BankModel
import com.aj.retrofitapi.model.BankRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class BankViewModel : ViewModel() {

    private val repository = BankRepository()

    private val bankMutableData = MutableLiveData<BankModel>()
    val bankLiveData: LiveData<BankModel> = bankMutableData

    fun fetchBankDetails(){
        viewModelScope.launch {
            try {

                val bank = repository.getBankDetails()
                bankMutableData.value= bank

            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

}