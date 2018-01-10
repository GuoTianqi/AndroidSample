package com.daybreak.androidsample.mvp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.daybreak.androidsample.BaseClassListActivity;
import com.daybreak.androidsample.mvp.view.UserLoginActivity;

public class MvpActivity extends BaseClassListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();

        if (Intent.ACTION_VIEW.equals(appLinkAction) && appLinkData != null) {
            Toast.makeText(MvpActivity.this, "mvp app link", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public Class[] getClassList() {
        Class[] classes = new Class[] {
                UserLoginActivity.class,
        };
        return classes;
    }
}
