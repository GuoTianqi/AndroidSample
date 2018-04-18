package com.daybreak.androidsample.customview;

import com.daybreak.androidsample.BaseClassListActivity;

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
                PieChartActivity.class,
                GestureDetectorActivity.class,
                ViewAttrExampleActivity.class,
                EventDispatchActivity.class,
                NestScrollViewActivity.class,
                MirrorImageViewActivity.class,
        };

        return myDataset;
    }
}
