package com.novelot.musiclibrary;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * 只为搭建框架时使用
 * Created by 刘云龙 on 2016/7/20.
 */
public class SideNavigationView extends LinearLayout {
    private View btnLeft;
    private View btnCenter;
    private View btnRight;

    public SideNavigationView(Context context) {
        super(context);
        init();
    }

    public SideNavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SideNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SideNavigationView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        View inflate = inflate(getContext(), R.layout.view_navigation, this);
        btnLeft = inflate.findViewById(R.id.btnLeft);
        btnCenter = inflate.findViewById(R.id.btnCenter);
        btnRight = inflate.findViewById(R.id.btnRight);
        this.setOrientation(VERTICAL);
    }

    public void setLeftOnClickListener(OnClickListener l) {
        btnLeft.setOnClickListener(l);
    }

    public void setCenterOnClickListener(OnClickListener l) {
        btnCenter.setOnClickListener(l);
    }

    public void setRightOnClickListener(OnClickListener l) {
        btnRight.setOnClickListener(l);
    }
}
