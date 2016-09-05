package com.nanastudio.sean.nofragmentdemo.first;

import com.nanastudio.sean.nofragmentdemo.R;

/**
 * NoFragmentDemo
 * Created by Sean on 2016/9/2下午12:01.
 */
public enum  FirstViewPagerEnum {

    RED(R.string.red,R.layout.view_red),
    YELLOW(R.string.yellow,R.layout.view_yellow),
    GREEN(R.string.green,R.layout.view_green);

    private int title;
    private int layoutId;

    FirstViewPagerEnum(int title,int layoutId) {
        this.title = title;
        this.layoutId = layoutId;
    }

    public int getTitleId() {
        return title;
    }

    public int getResourceId() {
        return layoutId;
    }
}
