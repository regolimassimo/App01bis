package com.massimoregoli.app01bis.viewmodel

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    private var name= MutableLiveData<String>("")

    fun setName(n: String) {
        name.value = n
    }

    fun doAction(context: LifecycleOwner, f: (it: String) -> Unit) {
        name.observe(context){
            f(it)
        }
    }

}