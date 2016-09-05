package com.nanastudio.sean.nofragmentdemo.first;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nanastudio.sean.nofragmentdemo.MainActivity;
import com.nanastudio.sean.nofragmentdemo.MainActivityContainer;

/**
 * NoFragmentDemo
 * Created by Sean on 2016/9/2上午11:59.
 */
public class FirstViewPagerAdapter extends PagerAdapter {

    private Context mContext;

    public FirstViewPagerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        FirstViewPagerEnum firstViewPagerEnum = FirstViewPagerEnum.values()[position];
        View subView = LayoutInflater.from(container.getContext())
                .inflate(firstViewPagerEnum.getResourceId(), container, false);
        subView.setOnClickListener(view -> ((MainActivity) mContext).getContainer()
                .pushView(MainActivityContainer.ViewType.SECOND));
        container.addView(subView);
        return subView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return FirstViewPagerEnum.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        FirstViewPagerEnum firstViewPagerEnum = FirstViewPagerEnum.values()[position];
        return mContext.getString(firstViewPagerEnum.getTitleId());
    }
}
