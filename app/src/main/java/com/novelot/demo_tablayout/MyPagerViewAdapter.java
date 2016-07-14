package com.novelot.demo_tablayout;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘云龙 on 2016/6/3.
 */
public class MyPagerViewAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    private List<Bean> mDate = new ArrayList();

    public MyPagerViewAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
        for (int i = 0; i < 14; i++) {
            mDate.add(new Bean("Name-" + i));
        }
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(MyFragment.KEY_EXTRA, mDate.get(position));
        return Fragment.instantiate(mContext, MyFragment.class.getName(), bundle);
    }

    @Override
    public int getCount() {
        return mDate == null ? 0 : mDate.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mDate.get(position).name;
    }
}
