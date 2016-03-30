package com.novelot.demo_tablayout;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        int i = 0;
        for (int count = 4; i < count; ++i) {
            mTabLayout.addTab(mTabLayout.newTab().setText("Title-" + i));
        }
    }

}
