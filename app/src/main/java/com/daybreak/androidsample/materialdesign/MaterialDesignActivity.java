package com.daybreak.androidsample.materialdesign;


import com.daybreak.androidsample.BaseClassListActivity;
import com.daybreak.androidsample.coordinatorlayout.items.AppBarLayoutActivity;
import com.daybreak.androidsample.coordinatorlayout.items.ClooapsingToolBarLayoutActivity;
import com.daybreak.androidsample.coordinatorlayout.items.FloatingActionButtonActivity;
import com.daybreak.androidsample.materialdesign.items.RecyclerViewActivity;
import com.daybreak.androidsample.materialdesign.items.SystemUIVisActivity;

public class MaterialDesignActivity extends BaseClassListActivity {

    @Override
    public Class[] getClassList() {
        Class[] classes = new Class[] {
                RecyclerViewActivity.class,
                SystemUIVisActivity.class,
        };
        return classes;
    }
}
