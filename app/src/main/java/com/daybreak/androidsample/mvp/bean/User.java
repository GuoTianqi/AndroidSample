package com.daybreak.androidsample.mvp.bean;

/**
 * Created by GuoTianqi on 2017/4/20.
 */

public class User {
    private String mUserName;
    private String mPassword;

    public User() {

    }

    public User(String username, String password) {
        mUserName = username;
        mPassword = password;
    }


    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
