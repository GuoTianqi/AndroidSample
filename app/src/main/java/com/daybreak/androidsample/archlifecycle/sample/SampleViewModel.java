package com.daybreak.androidsample.archlifecycle.sample;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class SampleViewModel extends ViewModel {
    private MutableLiveData<String> mCurrentName;

    public MutableLiveData<String> getCurrentName() {
        if (mCurrentName == null) {
            mCurrentName = new MutableLiveData<>();
        }

        return mCurrentName;
    }
}
