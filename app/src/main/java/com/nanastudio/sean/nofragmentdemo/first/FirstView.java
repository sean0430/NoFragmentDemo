package com.nanastudio.sean.nofragmentdemo.first;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.nanastudio.sean.nofragmentdemo.R;

/**
 * NoFragmentDemo
 * Created by Sean on 2016/9/2上午10:04.
 */
public class FirstView extends RelativeLayout {

    private ViewPager vpLight;

    public FirstView(Context context) {
        super(context);
    }

    public FirstView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FirstView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FirstView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setViewPager();
    }

    private void setViewPager() {
        vpLight = (ViewPager) findViewById(R.id.vpLight);
        vpLight.setAdapter(new FirstViewPagerAdapter(getContext()));
    }

    /*
        OnTabLayoutListener

        This listener is use to  wait tabLayout draw on view,
         then set something on tabLayout.
     */
    public interface OnTabLayoutListener {

        void onSetTabViewPager(TabLayout tabLayout);

    }

    OnTabLayoutListener onTabLayoutListener = new OnTabLayoutListener() {
        @Override
        public void onSetTabViewPager(TabLayout tabLayout) {
            tabLayout.setupWithViewPager(vpLight);
        }

    };

    public OnTabLayoutListener getOnTabLayoutListener() {
        return onTabLayoutListener;
    }
}
