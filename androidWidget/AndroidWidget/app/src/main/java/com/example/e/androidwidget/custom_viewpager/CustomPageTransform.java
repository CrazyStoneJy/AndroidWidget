package com.example.e.androidwidget.custom_viewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 自定义的pageTransform
 * Created by crazystone on 2016/5/10.
 */
public class CustomPageTransform extends CommonPageTransform {

    private ViewPager.PageTransformer mPageTransformer;
    private static final float DEFAULT_ALPHA = 0.5f;
    private static final float DEFAULT_SCALE = 0.8F;

    public CustomPageTransform() {

    }

    public CustomPageTransform(ViewPager.PageTransformer pageTransformer) {
        this.mPageTransformer = pageTransformer;
    }

    @Override
    protected void pageTransform(View page, float position) {
        float factor = 0;
        if (position < -1) {
            page.setAlpha(DEFAULT_ALPHA);
            page.setScaleX(DEFAULT_SCALE);
            page.setScaleY(DEFAULT_SCALE);
        } else if (position <= 1) {
            if (position >= 0) {
                factor = 1 - position;
            } else {
                factor = 1 + position;
            }
            page.setAlpha(DEFAULT_ALPHA + (1 - DEFAULT_ALPHA) * factor);
            page.setScaleX(DEFAULT_SCALE + (1 - DEFAULT_SCALE) * factor);
            page.setScaleY(DEFAULT_SCALE + (1 - DEFAULT_SCALE) * factor);
        } else {
            page.setAlpha(DEFAULT_ALPHA);
            page.setScaleX(DEFAULT_SCALE);
            page.setScaleY(DEFAULT_SCALE);
        }

    }
}
