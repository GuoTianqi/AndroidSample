package com.daybreak.androidsample.materialdesign.items;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;

public class SystemUIVisActivity extends BaseToolBarActivity implements CheckBox.OnCheckedChangeListener {
    private static class FlagData {
        public String name;
        public int flag;
        public boolean checked;

        public FlagData(String name, int flag, boolean checked) {
            this.name = name;
            this.flag = flag;
            this.checked = checked;
        }
    }

    private final FlagData[] sFlagDataArr = new FlagData[] {
            new FlagData("LOW_PROFILE", View.SYSTEM_UI_FLAG_LOW_PROFILE, false),
            new FlagData("HIDE_NAVIGATION", View.SYSTEM_UI_FLAG_HIDE_NAVIGATION, false),
            new FlagData("FULL_SCREEN", View.SYSTEM_UI_FLAG_FULLSCREEN, false),
            new FlagData("LAYOUT_STABLE", View.SYSTEM_UI_FLAG_LAYOUT_STABLE, false),
            new FlagData("LAYOUT_HIDE_NAVIGATION", View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION, false),
            new FlagData("LAYOUT_FULLSCREEN", View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN, false),
            new FlagData("IMMERSIVE", View.SYSTEM_UI_FLAG_IMMERSIVE, false),
            new FlagData("IMMERSIVE_STICKY", View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY, false),
            new FlagData("LIGHT_STATUS_BAR", View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR, false)
    };

    private ViewGroup mFlagCheckLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_system_uivis);

        mFlagCheckLayout = (ViewGroup) findViewById(R.id.flag_check_layout);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mFlagCheckLayout.getChildCount() > 0) {
            return;
        }

        // 设置 初始 Flags
        int visFlags = mCoordinatorLayout.getSystemUiVisibility();
        Log.e("XXX", "visFlags = " + visFlags);
        for (FlagData flagData : sFlagDataArr) {
            if ((visFlags & flagData.flag) != 0) {
                flagData.checked = true;
            }

            CheckBox checkBox = new CheckBox(SystemUIVisActivity.this);
            checkBox.setText(flagData.name);
            checkBox.setChecked(flagData.checked);
            checkBox.setTag(flagData);
            checkBox.setOnCheckedChangeListener(this);

            mFlagCheckLayout.addView(checkBox, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        FlagData flagData = (FlagData) buttonView.getTag();
        flagData.checked = isChecked;

        setSystemUIVis();
    }

    public void setSystemUIVis() {
        int flag = View.SYSTEM_UI_FLAG_VISIBLE;
        for (FlagData flagData : sFlagDataArr) {
            if (flagData.checked) {
                flag |= flagData.flag;
            }
        }

        getWindow().getDecorView().setSystemUiVisibility(flag);
    }
}
