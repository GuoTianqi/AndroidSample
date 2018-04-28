package com.daybreak.androidsample.databinding.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.view.View
import android.widget.Toast

class DataBindingViewModel(application: Application) : AndroidViewModel(application) {
    val user = User2()

    fun onClick(view: View) {
        if (user.friend) {
            Toast.makeText(getApplication(), "isFriend", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(getApplication(), "isEnemy", Toast.LENGTH_SHORT).show()
        }
    }
}