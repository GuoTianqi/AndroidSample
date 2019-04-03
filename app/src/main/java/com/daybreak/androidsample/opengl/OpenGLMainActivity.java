package com.daybreak.androidsample.opengl;

import android.content.Intent;

import com.daybreak.androidsample.BaseClassListActivity;
import com.daybreak.androidsample.opengl.simple.OpenGlSimpleActivity;

public class OpenGLMainActivity extends BaseClassListActivity {
    public static final Class[] classes = new Class[] {
            OpenGlSimpleActivity.class
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
