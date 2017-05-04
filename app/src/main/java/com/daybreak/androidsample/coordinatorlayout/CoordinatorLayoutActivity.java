package com.daybreak.androidsample.coordinatorlayout;


import com.daybreak.androidsample.BaseClassListActivity;
import com.daybreak.androidsample.coordinatorlayout.items.AppBarLayoutActivity;
import com.daybreak.androidsample.coordinatorlayout.items.ClooapsingToolBarLayoutActivity;
import com.daybreak.androidsample.coordinatorlayout.items.CoordinatorLayoutExploreActivity;
import com.daybreak.androidsample.coordinatorlayout.items.FloatingActionButtonActivity;
import com.daybreak.androidsample.mvp.view.UserLoginActivity;

public class CoordinatorLayoutActivity extends BaseClassListActivity {

    @Override
    public Class[] getClassList() {
        Class[] classes = new Class[] {
                FloatingActionButtonActivity.class,
                AppBarLayoutActivity.class,
                ClooapsingToolBarLayoutActivity.class,
                CoordinatorLayoutExploreActivity.class,
        };
        return classes;
    }
}
