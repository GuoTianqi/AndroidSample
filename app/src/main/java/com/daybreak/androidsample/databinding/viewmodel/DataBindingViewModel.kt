package com.daybreak.androidsample.databinding.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Toast
import java.util.*

class DataBindingViewModel(application: Application) : AndroidViewModel(application) {
    val user = User2()

    fun onClick(view: View) {
        if (user.friend) {
            Toast.makeText(getApplication(), "isFriend", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(getApplication(), "isEnemy", Toast.LENGTH_SHORT).show()
        }
    }

    val checked = MutableLiveData<Boolean>()
    val desc = MutableLiveData<String>()

    fun onDescTextChanged(text: Editable) {
        Log.e("XXX", text.toString())
//        desc.value = text.toString()
    }

    fun showCheckBoxChanged() {
        Log.e("XXX", "checked: ${checked.value}")
    }
}