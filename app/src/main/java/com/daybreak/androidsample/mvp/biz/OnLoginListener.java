package com.daybreak.androidsample.mvp.biz;

import com.daybreak.androidsample.mvp.bean.User;

/**
 * Created by GuoTianqi on 2017/4/20.
 */

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}
