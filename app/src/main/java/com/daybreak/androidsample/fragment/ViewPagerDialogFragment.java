package com.daybreak.androidsample.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daybreak.androidsample.R;

/**
 * Created by guotianqi on 16/7/17.
 */

public class ViewPagerDialogFragment extends DialogFragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private int mPagerCount = 3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_pager_dialog, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPagerAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = new ViewPagerFragment();
                return fragment;
            }

            @Override
            public int getCount() {
                return mPagerCount;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "Title " + position;
            }
        };

        view.findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPagerCount++;
                mViewPager.setAdapter(mPagerAdapter);
                mTabLayout.setupWithViewPager(mViewPager);
            }
        });

        view.findViewById(R.id.remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPagerCount--;
                if (mPagerCount < 0) {
                    mPagerCount = 0;
                }

                mViewPager.setAdapter(mPagerAdapter);
                mTabLayout.setupWithViewPager(mViewPager);
            }
        });

        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);

        mViewPager.setAdapter(mPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }
}
