package com.daybreak.androidsample.archlifecycle;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import com.daybreak.androidsample.BaseClassListActivity;
import com.daybreak.androidsample.archlifecycle.sample.ArchLifeCycleSampleActivity;

public class ArchLifecycleActivity extends BaseClassListActivity {
    public static final Class[] classes = new Class[] {
            ArchLifeCycleSampleActivity.class,
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
