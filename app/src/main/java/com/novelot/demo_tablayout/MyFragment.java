package com.novelot.demo_tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 刘云龙 on 2016/6/3.
 */
public class MyFragment extends Fragment {
    public static final String KEY_EXTRA = "key";
    private Bean data;
    private ViewPager mViewPager;
    private PagerAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            data = arguments.getParcelable(KEY_EXTRA);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub, null);
        mViewPager = (ViewPager) view.findViewById(R.id.vp);
        mAdapter = new SubPagerViewAdapter(getActivity(),this.getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
        return view;
    }


}
