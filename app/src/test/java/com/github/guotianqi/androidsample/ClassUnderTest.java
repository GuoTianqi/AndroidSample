package com.github.guotianqi.androidsample;

import android.content.Context;

import com.daybreak.androidsample.R;

/**
 * Created by GuoTianqi on 2017/5/26.
 */

public class ClassUnderTest {
    private Context mContext;
    public ClassUnderTest(Context context) {
        mContext = context;
    }
    public String getAppNameString() {
        return mContext.getString(R.string.app_name);
    }
}
