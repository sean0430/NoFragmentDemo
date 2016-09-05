package com.nanastudio.sean.nofragmentdemo.second;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * NoFragmentDemo
 * Created by Sean on 2016/9/2上午10:04.
 */
public class SecondView extends RelativeLayout {
    public SecondView(Context context) {
        super(context);
    }

    public SecondView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SecondView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SecondView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
