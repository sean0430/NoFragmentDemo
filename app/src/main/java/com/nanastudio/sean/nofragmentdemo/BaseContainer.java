package com.nanastudio.sean.nofragmentdemo;

/**
 * NoFragmentDemo
 * Created by Sean on 2016/9/2上午9:53.
 */
public interface BaseContainer {

    void inflateViewByLayoutId(int layoutId);

    boolean onBackPress();

    void removeFromParent();
}
