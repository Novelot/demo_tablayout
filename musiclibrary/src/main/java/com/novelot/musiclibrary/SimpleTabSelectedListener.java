package com.novelot.musiclibrary;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

/**
 * Created by 刘云龙 on 2016/7/18.
 */
public class SimpleTabSelectedListener implements TabLayout.OnTabSelectedListener {

    private android.support.v4.view.ViewPager mViewPager;

    public SimpleTabSelectedListener(ViewPager viewPager) {
        this.mViewPager = viewPager;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if (mViewPager != null) {
            mViewPager.setCurrentItem(tab.getPosition());
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }
}
