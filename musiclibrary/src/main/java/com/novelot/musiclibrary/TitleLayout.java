package com.novelot.musiclibrary;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * 节目库顶端控件
 * Created by 刘云龙 on 2016/7/18.
 */
public class TitleLayout extends LinearLayout {
    private TabLayout mTabLayout;
    private View btnLeft;
    private View btnRight;

    public TitleLayout(Context context) {
        super(context);
        init();
    }

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TitleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TitleLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        View inflate = inflate(getContext(), R.layout.layout_title, this);
        mTabLayout = (TabLayout) inflate.findViewById(R.id.tabLayout);
        btnLeft = inflate.findViewById(R.id.btnLeft);
        btnRight = inflate.findViewById(R.id.btnRight);
        this.setOrientation(HORIZONTAL);
    }

    /**
     * 此方法必须在viewPager.setAdapter(mAdapter)之后调用;
     *
     * @param viewPager
     */
    public void setupWithViewPager(@NonNull ViewPager viewPager) {
        mTabLayout.setupWithViewPager(viewPager);
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener l) {
        mTabLayout.setOnTabSelectedListener(l);
    }

    public void setLeftOnClickListener(OnClickListener l) {
        btnLeft.setOnClickListener(l);
    }

    public void setRightOnClickListener(OnClickListener l) {
        btnRight.setOnClickListener(l);
    }

    /**
     * @param v View.VISIBLE,View.INVISIBLE,View.Gone
     */
    public void setLeftVisibility(int v) {
        btnLeft.setVisibility(v);
    }

    /**
     * @param v View.VISIBLE,View.INVISIBLE,View.Gone
     */
    public void setRightVisibility(int v) {
        btnLeft.setVisibility(v);
    }
}
