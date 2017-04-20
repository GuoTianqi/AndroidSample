package com.daybreak.androidsample.mvp.biz;

import com.daybreak.androidsample.mvp.bean.User;

/**
 * Created by GuoTianqi on 2017/4/20.
 */

public class UserBiz implements IUserBiz {
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
         new Thread() {
             @Override
             public void run() {
                 try {
                     Thread.sleep(2000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }

                 if ("gtq".equals(username) && "123".equals(password)) {
                     User user = new User(username, password);
                     loginListener.loginSuccess(user);
                 } else {
                     loginListener.loginFailed();
                 }
             }
         }.start();
    }
}
