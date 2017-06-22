package com.daybreak.androidsample.materialdesign.items;

import android.animation.ObjectAnimator;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.TintAwareDrawable;
import android.support.v4.view.WindowCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.view.View;
import android.view.Window;

import com.daybreak.androidsample.R;

public class CoordinatorLayoutExploreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setEnterTransition(new Explode());
            getWindow().setReturnTransition(new Fade());
            // getWindow().setSharedElementEnterTransition(new ChangeImageTransform());
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout_explore);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
             }
        });

        final CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        toolbarLayout.setTitle("Clooapsing");
        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        Palette.from(BitmapFactory.decodeResource(getResources(), R.drawable.flower))
                .generate(new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(Palette palette) {
                        Palette.Swatch swatch = palette.getVibrantSwatch();
                        toolbarLayout.setBackgroundColor(swatch.getRgb());
                        toolbarLayout.setCollapsedTitleTextColor(swatch.getBodyTextColor());
                        toolbarLayout.setExpandedTitleColor(swatch.getTitleTextColor());
                        toolbarLayout.setStatusBarScrimColor(swatch.getRgb());
                        toolbarLayout.setContentScrimColor(swatch.getRgb());
                        DrawableCompat.setTint(toolbar.getNavigationIcon(), swatch.getTitleTextColor());
                    }
                });




        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v , "FAB", Snackbar.LENGTH_LONG)
                        .setAction("cancel", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .show();
            }
        });
    }
}
