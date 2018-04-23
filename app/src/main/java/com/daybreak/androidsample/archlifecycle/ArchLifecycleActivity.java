package com.daybreak.androidsample.archlifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daybreak.androidsample.BaseClassListActivity;
import com.daybreak.androidsample.R;
import com.daybreak.androidsample.archlifecycle.sample.ArchLifeCycleSampleActivity;
import com.daybreak.androidsample.drawable.DrawableBoundsActivity;
import com.daybreak.androidsample.drawable.DrawableRepeatActivity;
import com.daybreak.androidsample.drawable.DrawableTintActivity;

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
