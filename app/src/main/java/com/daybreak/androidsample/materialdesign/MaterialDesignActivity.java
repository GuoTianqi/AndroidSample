package com.daybreak.androidsample.materialdesign;


import com.daybreak.androidsample.BaseClassListActivity;
import com.daybreak.androidsample.coordinatorlayout.items.AppBarLayoutActivity;
import com.daybreak.androidsample.coordinatorlayout.items.ClooapsingToolBarLayoutActivity;
import com.daybreak.androidsample.coordinatorlayout.items.FloatingActionButtonActivity;
import com.daybreak.androidsample.materialdesign.items.RecyclerViewActivity;

public class MaterialDesignActivity extends BaseClassListActivity {

    @Override
    public Class[] getClassList() {
        Class[] classes = new Class[] {
                RecyclerViewActivity.class,
        };
        return classes;
    }
}
