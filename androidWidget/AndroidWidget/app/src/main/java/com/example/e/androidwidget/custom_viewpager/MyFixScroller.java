package com.example.e.androidwidget.custom_viewpager;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/**
 * Created by crazystone on 2016/5/10.
 */
public class MyFixScroller extends Scroller {



    public MyFixScroller(Context context) {
        super(context);
    }

    public MyFixScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public MyFixScroller(Context context, Interpolator interpolator, boolean flywheel) {
        super(context, interpolator, flywheel);
    }


}
