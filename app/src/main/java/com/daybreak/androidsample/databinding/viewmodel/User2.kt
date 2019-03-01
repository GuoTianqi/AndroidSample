package com.daybreak.androidsample.databinding.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import android.view.View
import com.daybreak.androidsample.BR

class User2 : BaseObservable() {
    @field:Bindable var firstName: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.firstName)
        }
    @field:Bindable var lastName: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.lastName)
        }
    @field:Bindable var friend: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.friend)
        }
    @field:Bindable var adult: Boolean  = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.adult)
        }
    @field:Bindable var email: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.email)
        }

    private var index = 0


    init {
        notifyChange()
    }

    fun changeAttr(view: View) {
        index = (index + 1) % firstNames.size
        firstName = firstNames[index]
        lastName = lastNames[index]
        friend = isFriends[index]
        adult = isAdults[index]

        notifyChange()
    }

    companion object {
        private val firstNames = arrayOf("AAAA", "BBBB", "CCCCCn", "DDDDDDD")
        private val lastNames = arrayOf("GuoAA", "LinLLL", "GuoBBn", "GuoCCC")
        private val isFriends = booleanArrayOf(true, true, false, false)
        private val isAdults = booleanArrayOf(false, false, true, true)
    }
}
