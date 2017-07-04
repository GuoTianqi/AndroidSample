package com.daybreak.androidsample;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends BaseToolBarActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private static class NameToActivity {
        public String name;
        public String clsName;

        public NameToActivity(String name, String clsName) {
            this.name = name;
            this.clsName = clsName;
        }
    }

    private List<NameToActivity> mNameToActivityList = new ArrayList<>();

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_main);
        mToolBar.setNavigationIcon(null);
        mListView = (ListView) findViewById(R.id.list_view);
        getActivities();
        initListView();
    }

    private void getActivities() {
        Intent intent = new Intent(getResources().getString(R.string.main_activity_list_item_intent_action));
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        List<ResolveInfo> resolveInfoList =
                getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        for (ResolveInfo info : resolveInfoList) {
            CharSequence label = info.activityInfo.loadLabel(getPackageManager());
            String activityName = info.activityInfo.name;
            mNameToActivityList.add(
                    new NameToActivity(label.toString(), activityName)
            );

            Log.d(TAG, "" + label + ", " + activityName);
        }

        Collections.sort(mNameToActivityList, new Comparator<NameToActivity>() {
            @Override
            public int compare(NameToActivity lhs, NameToActivity rhs) {
                return lhs.name.compareTo(rhs.name);
            }
        });
    }

    private void initListView() {
        mListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return mNameToActivityList.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(MainActivity.this).inflate(android.R.layout.simple_list_item_1, null);
                }

                TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
                textView.setText(mNameToActivityList.get(position).name);

                return convertView;
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClassName(MainActivity.this, mNameToActivityList.get(position).clsName);
                startActivity(intent);
            }
        });
    }
}
