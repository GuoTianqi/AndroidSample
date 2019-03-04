package com.daybreak.androidsample.archlifecycle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.os.Handler;
import android.os.Message;

public class NameViewModel extends ViewModel {

    // Create a LiveData with a String
    private MutableLiveData<String> mCurrentName;

    public MutableLiveData<String> getCurrentName() {
//        if (mCurrentName == null) {
//            mCurrentName = new MutableLiveData<String>();
//
//            getNameFromNetwork(new Handler.Callback() {
//                public boolean success(String userName) {
//                    mCurrentName.setValue(userName);
//                }
//            });
//        }
        return mCurrentName;
    }


    private void getNameFromNetwork(Handler.Callback callback) {

    }

// Rest of the ViewModel...
}
