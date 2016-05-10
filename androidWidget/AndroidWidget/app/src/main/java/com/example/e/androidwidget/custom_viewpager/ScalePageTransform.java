package com.example.e.androidwidget.custom_viewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by crazystone on 2016/5/10.
 */
public class ScalePageTransform extends CommonPageTransform {

    private static final float DEFAULT_SCALE = 0.8F;
    private ViewPager.PageTransformer mPageTransform;
    private float mScale;

    public ScalePageTransform() {
        this(DEFAULT_SCALE, NonPageTransfrom.NO_PAGE_TRANSFER);
    }

    public ScalePageTransform(float scale) {
        this(scale, NonPageTransfrom.NO_PAGE_TRANSFER);
    }

    public ScalePageTransform(ViewPager.PageTransformer pageTransformer) {
        this(DEFAULT_SCALE, NonPageTransfrom.NO_PAGE_TRANSFER);
    }

    public ScalePageTransform(float scale, ViewPager.PageTransformer pageTransformer) {
        this.mScale = scale;
        this.mPageTransform = pageTransformer;
    }

    @Override
    protected void pageTransform(View page, float position) {
        float factor = 0;
        if (position < -1) {
            page.setScaleX(DEFAULT_SCALE);
            page.setScaleY(DEFAULT_SCALE);
        } else if (position < 1) {
            factor = 1-Math.abs(position);
            page.setScaleX(mScale + factor * (1 - mScale));
            page.setScaleY(mScale + factor * (1 - mScale));
        } else {
            page.setScaleX(DEFAULT_SCALE);
            page.setScaleY(DEFAULT_SCALE);
        }
    }
}
