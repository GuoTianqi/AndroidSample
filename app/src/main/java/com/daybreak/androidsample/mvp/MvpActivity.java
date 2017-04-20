package com.daybreak.androidsample.mvp;


import com.daybreak.androidsample.BaseClassListActivity;
import com.daybreak.androidsample.mvp.view.UserLoginActivity;

public class MvpActivity extends BaseClassListActivity {

    @Override
    public Class[] getClassList() {
        Class[] classes = new Class[] {
                UserLoginActivity.class,
        };
        return classes;
    }
}
