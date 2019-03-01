package com.daybreak.androidsample.databinding.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import android.text.Editable
import android.text.format.Time
import android.util.Log
import android.view.View
import android.widget.Toast
import java.util.*

class DataBindingViewModel(application: Application) : AndroidViewModel(application) {
    val user = User2()
    val customTextObservableField = ObservableField<CharSequence>()

    init {
        val customText = "Hello World"
        customTextObservableField.set(customText)
    }

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

    fun buttonClick() {

    }
}