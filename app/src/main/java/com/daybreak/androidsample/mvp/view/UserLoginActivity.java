package com.daybreak.androidsample.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;
import com.daybreak.androidsample.mvp.bean.User;
import com.daybreak.androidsample.mvp.presenter.UserLoginPresenter;

/**
 * Created by GuoTianqi on 2017/4/20.
 */

public class UserLoginActivity extends BaseToolBarActivity implements IUserLgoinView {
    private EditText mUsername;
    private EditText mPassword;
    private Button mLogin;
    private Button mClear;
    private ProgressBar mProgressbar;

    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Mvp User Login");
        setContentLayout(R.layout.activity_user_login);

        initViews();
    }

    private void initViews() {
        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        mLogin = (Button) findViewById(R.id.login);
        mClear = (Button) findViewById(R.id.clear);
        mProgressbar = (ProgressBar) findViewById(R.id.progressbar);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.login();
            }
        });

        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return mUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPassword.getText().toString();
    }

    @Override
    public void showLoading() {
        mProgressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressbar.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, String.format(getString(R.string.login_succes_toast_text), user.getUserName()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearUserName() {
        mUsername.setText("");
    }

    @Override
    public void clearPassword() {
        mPassword.setText("");
    }
}
