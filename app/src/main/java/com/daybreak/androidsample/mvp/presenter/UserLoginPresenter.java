package com.daybreak.androidsample.mvp.presenter;

import android.os.Handler;

import com.daybreak.androidsample.mvp.bean.User;
import com.daybreak.androidsample.mvp.biz.IUserBiz;
import com.daybreak.androidsample.mvp.biz.OnLoginListener;
import com.daybreak.androidsample.mvp.biz.UserBiz;
import com.daybreak.androidsample.mvp.view.IUserLgoinView;

/**
 * Created by GuoTianqi on 2017/4/20.
 */

public class UserLoginPresenter {
    private IUserBiz mUserBiz;
    private IUserLgoinView mUserLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLgoinView userLgoinView) {
        mUserLoginView = userLgoinView;
        mUserBiz = new UserBiz();
    }

    public void login() {
        mUserLoginView.showLoading();

        mUserBiz.login(mUserLoginView.getUserName(), mUserLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mUserLoginView.toMainActivity(user);
                        mUserLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mUserLoginView.showFailedError();
                        mUserLoginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear() {
        mUserLoginView.clearUserName();
        mUserLoginView.clearPassword();
    }
}
