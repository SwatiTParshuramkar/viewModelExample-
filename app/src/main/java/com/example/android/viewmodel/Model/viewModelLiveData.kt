package com.example.android.viewmodel.Model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class viewModelLiveData: ViewModel() {
    var number = 0
    val  currentNumber : MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }
    val  currentboolean: MutableLiveData<Boolean> by lazy{
        MutableLiveData<Boolean>()
    }

}
