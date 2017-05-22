package com.daybreak.androidsample.customview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daybreak.androidsample.BaseClassListActivity;
import com.daybreak.androidsample.R;
import com.daybreak.androidsample.customview.view.TextContentView;

import java.lang.ref.WeakReference;

public class CustomViewActivity extends BaseClassListActivity {
    @Override
    public Class[] getClassList() {
        Class[] myDataset = new Class[] {
                PlaygroundViewActivity.class,
                SloopViewActivity.class,
                PieViewActivity.class,
                PictureActivity.class,
                CheckViewActivity.class,
                PathViewActivity.class,
                Bezier2ViewActivity.class,
                Bezier3ViewActivity.class,
                PathMeasureActivity.class,
                SearchViewActivity.class,
                SetPolyToPolyViewActivity.class,
                Rotate3dAnimationActivity.class,
                RegionClickViewActivity.class,
                RemoteControlMenuActivity.class,
                MultiTouchViewActivity.class,
                DragViewActivity.class,
                TextContentViewActivity.class,
        };

        return myDataset;
    }
}
