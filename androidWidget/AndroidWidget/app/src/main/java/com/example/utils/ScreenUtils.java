package com.example.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.DisplayMetrics;

/**
 * Created by e on 2016/5/10.
 */
public class ScreenUtils {

    public static float dp2px(Activity aty, float dp) {
        DisplayMetrics metrics = new DisplayMetrics();
        aty.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float density = metrics.density;
        return dp * density + 0.5f;
    }

    public static float px2dp(Activity aty, float px) {
        DisplayMetrics metrics = new DisplayMetrics();
        aty.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float density = metrics.density;
        return px / density + 0.5f;
    }

}
