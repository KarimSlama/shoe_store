package com.example.shoestore.shoe_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.data.ShoeData

class ShoeListViewModel() : ViewModel() {

    private val _shoeItem = MutableLiveData<MutableList<ShoeData>>()
    val shoeItem: LiveData<MutableList<ShoeData>>
        get() = _shoeItem

    fun addNewShoeItem(shoe: ShoeData) {
        if (_shoeItem.value == null) {
            _shoeItem.value = mutableListOf(shoe)
        } else {
            _shoeItem.value?.add(shoe)
        }//end else
    }//end addNewShoeItem()

}//end class