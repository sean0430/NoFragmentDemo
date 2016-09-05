package com.nanastudio.sean.nofragmentdemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.nanastudio.sean.nofragmentdemo.first.FirstView;
import com.nanastudio.sean.nofragmentdemo.second.SecondView;

/**
 * NoFragmentDemo
 * Created by Sean on 2016/9/2上午9:26.
 */
public class MainActivityContainer extends RelativeLayout
        implements BaseContainer {

    private MainActivity mainActivity = (MainActivity) getContext();

    public enum ViewType {
        FIRST, SECOND
    }

    private FirstView firstView;

    public MainActivityContainer(Context context) {
        super(context);
    }

    public MainActivityContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MainActivityContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MainActivityContainer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        pushView(ViewType.FIRST);
    }

    @Override
    public void inflateViewByLayoutId(int layoutId) {
        inflate(getContext(), layoutId, this);
    }

    @Override
    public boolean onBackPress() {
        // If current view is second view change to first view
        // Else finish Activity.
        if (getChildAt(0) instanceof SecondView) {
            pushView(ViewType.FIRST);
            return false;

        } else {
            return true;
        }
    }

    @Override
    public void removeFromParent() {
        removeAllViews();
    }

    @Override
    protected void detachAllViewsFromParent() {
        super.detachAllViewsFromParent();
        removeAllViews();
    }

    /*
        Push to another view
     */

    public void pushView(ViewType viewType) {

        viewChangeAnimation();
        removeAllViews();

        switch (viewType) {
            case FIRST:
                pushToFirstView();
                break;

            case SECOND:
                pushToSecondView();
                break;
        }
    }

    private void pushToFirstView() {
        if (mainActivity.getTabLayout() != null
                && mainActivity.getTabLayout().getVisibility() != VISIBLE) {
            mainActivity.getTabLayout().setVisibility(VISIBLE);
            mainActivity.setActionBarTitle(getResources()
                    .getString(R.string.first_view));
        }

        if (firstView == null) {
            inflateViewByLayoutId(R.layout.view_first);
            firstView = (FirstView) getChildAt(0);

        } else {
            addView(firstView);
        }

    }

    private void pushToSecondView() {
        mainActivity.getTabLayout().setVisibility(GONE);
        mainActivity.setActionBarTitle(getResources()
                .getString(R.string.second_view));
        inflateViewByLayoutId(R.layout.view_second);
    }


    /*
        View change animation
     */

    private void viewChangeAnimation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(this);
        }
    }



}
