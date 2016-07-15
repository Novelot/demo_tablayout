package com.novelot.demo_tablayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvTab;
    private PagerAdapter mAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp = getSharedPreferences("novelot", Context.MODE_PRIVATE);
        boolean witchLayout = sp.getBoolean("witchLayout", true);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("witchLayout", !witchLayout);
        editor.commit();
        if (witchLayout) {
            setContentView(R.layout.activity_main);
        } else {
            setContentView(R.layout.activity_main_2);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_search);
            toolbar.inflateMenu(R.menu.menu_main);
        }

        //find view
        mViewPager = (MyViewPager) findViewById(R.id.viewPager);
        tvTab = (TextView) findViewById(R.id.tv);
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        //setup adapte and setup viewpager;
        mAdapter = new MyPagerViewAdapter(this, getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);//此方法必须在viewPager.setAdapter(mAdapter);之后

        /*setupWithViewPager方法之后,无需再调用下边的方法,添加标题;否则,会出现双份*/
//        int count = mAdapter.getCount();
//        for (int i = 0; i < count; i++) {
//            CharSequence title = mAdapter.getPageTitle(i);
//            mTabLayout.addTab(mTabLayout.newTab().setText(title));
//        }

        //set tab selected listener
        /*必须设置这个监听,否则点击Tab的时候,viewpager 不会随之切换*/
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());

                tvTab.setText(tab.getPosition() + " selected");

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tvTab.setText(tab.getPosition() + " unselected");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tvTab.setText(tab.getPosition() + " reselected");
            }
        });

        //

    }

}
