package com.novelot.demo_tablayout;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTab = (TextView) findViewById(R.id.tv);
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        int i = 0;
        for (int count = 4; i < count; ++i) {
            mTabLayout.addTab(mTabLayout.newTab().setText("Title-" + i));
        }

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tvTab.setText(tab.getPosition() + " selected");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tvTab.setText(tab.getPosition() + " unselected");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Do nothing
                tvTab.setText(tab.getPosition() + " reselected");
            }
        });
    }

}
