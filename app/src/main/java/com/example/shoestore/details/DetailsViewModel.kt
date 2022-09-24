package com.example.shoestore.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.data.ShoeData

class DetailsViewModel : ViewModel() {

    val shoeName = MutableLiveData<String>()
    val shoeCompany = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()
    val shoeDesc = MutableLiveData<String>()

    fun addNewShoe(): ShoeData {
        return ShoeData(
            shoeName.value ?: "",
            shoeCompany.value ?: "",
            shoeSize.value!!.toDouble(),
            shoeDesc.value ?: ""
        )
    }//end addNewShoe()
}//end class