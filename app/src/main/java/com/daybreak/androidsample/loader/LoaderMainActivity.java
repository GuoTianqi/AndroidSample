package com.daybreak.androidsample.loader;

import android.content.Intent;

import com.daybreak.androidsample.BaseClassListActivity;
import com.daybreak.androidsample.archlifecycle.sample.ArchLifeCycleSampleActivity;
import com.daybreak.androidsample.loader.contacts.ContactsLoaderActivity;

public class LoaderMainActivity extends BaseClassListActivity {
    public static final Class[] classes = new Class[] {
            ContactsLoaderActivity.class,
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
