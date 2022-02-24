package com.gatsu.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel() {
    val message: MutableLiveData<String>by lazy {// by lazy позволяет создать один раз а не персоздавать постоянно
        MutableLiveData<String>()// liveData обновляет в зависимости от жизни активн
    }
    val messageFragment1: MutableLiveData<String>by lazy {
        MutableLiveData<String>()
    }
    val messageFragment2: MutableLiveData<String>by lazy {
        MutableLiveData<String>()
    }

}