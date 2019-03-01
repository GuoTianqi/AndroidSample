package com.daybreak.androidsample.test;

import com.daybreak.androidsample.BaseClassListActivity;
import com.daybreak.androidsample.customview.Bezier2ViewActivity;
import com.daybreak.androidsample.customview.Bezier3ViewActivity;
import com.daybreak.androidsample.customview.CheckViewActivity;
import com.daybreak.androidsample.customview.DragViewActivity;
import com.daybreak.androidsample.customview.EventDispatchActivity;
import com.daybreak.androidsample.customview.GestureDetectorActivity;
import com.daybreak.androidsample.customview.MultiTouchViewActivity;
import com.daybreak.androidsample.customview.NestScrollViewActivity;
import com.daybreak.androidsample.customview.PathMeasureActivity;
import com.daybreak.androidsample.customview.PathViewActivity;
import com.daybreak.androidsample.customview.PictureActivity;
import com.daybreak.androidsample.customview.PieChartActivity;
import com.daybreak.androidsample.customview.PieViewActivity;
import com.daybreak.androidsample.customview.PlaygroundViewActivity;
import com.daybreak.androidsample.customview.RegionClickViewActivity;
import com.daybreak.androidsample.customview.RemoteControlMenuActivity;
import com.daybreak.androidsample.customview.Rotate3dAnimationActivity;
import com.daybreak.androidsample.customview.SearchViewActivity;
import com.daybreak.androidsample.customview.SetPolyToPolyViewActivity;
import com.daybreak.androidsample.customview.SloopViewActivity;
import com.daybreak.androidsample.customview.TextContentViewActivity;
import com.daybreak.androidsample.customview.ViewAttrExampleActivity;

public class TestMainActivity extends BaseClassListActivity {
    @Override
    public Class[] getClassList() {
        Class[] myDataset = new Class[] {
                CameraDistanceActivity.class,
                ScrollBarActivity.class,
                TranslucentStatusActivity.class
        };

        return myDataset;
    }
}
