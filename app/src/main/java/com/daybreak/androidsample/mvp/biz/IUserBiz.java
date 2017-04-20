package com.daybreak.androidsample.mvp.biz;

/**
 * Created by GuoTianqi on 2017/4/20.
 */

public interface IUserBiz {
    public void login(String username, String password, OnLoginListener loginListener);
}
