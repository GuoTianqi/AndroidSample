package com.daybreak.androidsample.materialdesign;


import com.daybreak.androidsample.BaseClassListActivity;
import com.daybreak.androidsample.materialdesign.items.AppBarLayoutActivity;
import com.daybreak.androidsample.materialdesign.items.ClooapsingToolBarLayoutActivity;
import com.daybreak.androidsample.materialdesign.items.ConstraintLayoutActivity;
import com.daybreak.androidsample.materialdesign.items.CoordinatorLayoutExploreActivity;
import com.daybreak.androidsample.materialdesign.items.FloatingActionButtonActivity;
import com.daybreak.androidsample.materialdesign.items.RecyclerViewActivity;
import com.daybreak.androidsample.materialdesign.items.SystemUIVisActivity;
import com.daybreak.androidsample.materialdesign.items.ToolbarLayoutActivity;

public class MaterialDesignActivity extends BaseClassListActivity {

    @Override
    public Class[] getClassList() {
        Class[] classes = new Class[] {
                RecyclerViewActivity.class,
                SystemUIVisActivity.class,
                FloatingActionButtonActivity.class,
                AppBarLayoutActivity.class,
                ClooapsingToolBarLayoutActivity.class,
                CoordinatorLayoutExploreActivity.class,
                ConstraintLayoutActivity.class,
                ToolbarLayoutActivity.class
        };
        return classes;
    }
}
