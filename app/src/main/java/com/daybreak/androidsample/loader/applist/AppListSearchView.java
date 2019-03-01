package com.daybreak.androidsample.loader.applist;

import android.content.Context;
import androidx.appcompat.widget.SearchView;
import android.util.AttributeSet;

public class AppListSearchView extends SearchView {
    public AppListSearchView(Context context) {
        super(context);
    }

    public AppListSearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AppListSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // The normal SearchView doesn't clear its search text when
    // collapsed, so we will do this for it.
    @Override
    public void onActionViewCollapsed() {
        setQuery("", false);
        super.onActionViewCollapsed();
    }
}
