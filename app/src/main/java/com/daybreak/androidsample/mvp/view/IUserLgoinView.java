package com.daybreak.androidsample.mvp.view;

import com.daybreak.androidsample.mvp.bean.User;

/**
 * Created by GuoTianqi on 2017/4/20.
 */

public interface IUserLgoinView {
    String getUserName();
    String getPassword();

    void showLoading();
    void hideLoading();

    void toMainActivity(User user);
    void showFailedError();

    void clearUserName();
    void clearPassword();

}
