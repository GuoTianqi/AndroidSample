package com.daybreak.androidsample.materialdesign;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Window;

import com.daybreak.androidsample.BaseClassListActivity;
import com.daybreak.androidsample.materialdesign.items.BottomSheetBehaviorActivity;
import com.daybreak.androidsample.materialdesign.items.CustomTabsActivity;
import com.daybreak.androidsample.materialdesign.items.AppBarLayoutActivity;
import com.daybreak.androidsample.materialdesign.items.ClooapsingToolBarLayoutActivity;
import com.daybreak.androidsample.materialdesign.items.ConstraintLayoutActivity;
import com.daybreak.androidsample.materialdesign.items.CoordinatorLayoutExploreActivity;
import com.daybreak.androidsample.materialdesign.items.FloatingActionButtonActivity;
import com.daybreak.androidsample.materialdesign.items.KotlinActivity;
import com.daybreak.androidsample.materialdesign.items.MaterialAnimationActivity;
import com.daybreak.androidsample.materialdesign.items.NavigationDrawerActivity;
import com.daybreak.androidsample.materialdesign.items.RecyclerViewActivity;
import com.daybreak.androidsample.materialdesign.items.SwipeRefreshLayoutActivity;
import com.daybreak.androidsample.materialdesign.items.SystemUIVisActivity;
import com.daybreak.androidsample.materialdesign.items.ToolbarLayoutActivity;
import com.daybreak.androidsample.materialdesign.items.transitions.TransitionsMainActivity;

public class MaterialDesignActivity extends BaseClassListActivity {
    public static final Class[] classes = new Class[] {
            MaterialAnimationActivity.class,
            NavigationDrawerActivity.class,
            RecyclerViewActivity.class,
            SystemUIVisActivity.class,
            FloatingActionButtonActivity.class,
            AppBarLayoutActivity.class,
            ClooapsingToolBarLayoutActivity.class,
            CoordinatorLayoutExploreActivity.class,
            ConstraintLayoutActivity.class,
            ToolbarLayoutActivity.class,
            SwipeRefreshLayoutActivity.class,
            KotlinActivity.class,
            TransitionsMainActivity.class,
            BottomSheetBehaviorActivity.class,
            CustomTabsActivity.class
    };

    @Override
    public Class[] getClassList() {
        return classes;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }

        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onItemClick(int position) {
        Intent intent = new Intent(this, classes[position]);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setExitTransition(new Explode());
//            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
//        } else {
            startActivity(intent);
//        }

        return true;
    }
}
