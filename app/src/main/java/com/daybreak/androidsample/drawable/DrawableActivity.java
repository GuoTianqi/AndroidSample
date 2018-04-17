package com.daybreak.androidsample.drawable;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Window;

import com.daybreak.androidsample.BaseClassListActivity;
import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;

public class DrawableActivity extends BaseClassListActivity {
    public static final Class[] classes = new Class[] {
            DrawableRepeatActivity.class,
            DrawableTintActivity.class,
    };

    @Override
    public Class[] getClassList() {
        return classes;
    }

    @Override
    public boolean onItemClick(int position) {
        Intent intent = new Intent(this, classes[position]);
        startActivity(intent);

        return true;
    }
}
