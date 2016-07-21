package com.novelot.musiclibrary;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * 节目库主Fragment
 */
public class MusicLibraryFragment extends Fragment {


    public MusicLibraryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_music_library, container, false);
        TitleLayout mTitleLayout = (TitleLayout) rootView.findViewById(R.id.layoutTitle);
        ViewPager mViewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
        //setup adapte and setup viewpager;
        MusicLibraryPagerViewAdapter mAdapter = new MusicLibraryPagerViewAdapter(getContext(), getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTitleLayout.setupWithViewPager(mViewPager);
        mTitleLayout.setOnTabSelectedListener(new SimpleTabSelectedListener(mViewPager));
        mTitleLayout.setRightOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return rootView;
    }

}
