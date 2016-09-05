package com.nanastudio.sean.nofragmentdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.nanastudio.sean.nofragmentdemo.first.FirstView;

public class MainActivity extends AppCompatActivity {

    private MainActivityContainer mainActivityContainer;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setActionBarTitle(getString(R.string.first_view));

        mainActivityContainer = (MainActivityContainer) findViewById(R.id.mainActivityContainer);

        FirstView firstView = (FirstView) mainActivityContainer.getChildAt(0);
        FirstView.OnTabLayoutListener onTabLayoutListener = firstView.getOnTabLayoutListener();

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
        onTabLayoutListener.onSetTabViewPager(tabLayout);

    }

    @Override
    public void onBackPressed() {
        if (mainActivityContainer.onBackPress()) {
            super.onBackPressed();
        }
    }

    public TabLayout getTabLayout() {
        return tabLayout;
    }

    public MainActivityContainer getContainer() {
        return mainActivityContainer;
    }

    public void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }


}
