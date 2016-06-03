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
public class SubPagerViewAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    private List<Bean> mData = new ArrayList<Bean>();

    public SubPagerViewAdapter(Context context, FragmentManager childFragmentManager) {
        super(childFragmentManager);
        this.mContext = context;

        for (int i = 0; i < 2; i++) {
            mData.add(new Bean("Sub-" + i));
        }
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(SubFragment.KEY_EXTRA, mData.get(position));
        return Fragment.instantiate(mContext, SubFragment.class.getName(), bundle);
    }

    @Override
    public int getCount() {
        return mData.size();
    }
}
