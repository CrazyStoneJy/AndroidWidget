package com.example.e.androidwidget.custom_viewpager;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by e on 2016/5/9.
 */
public abstract class CommonPageTransform implements ViewPager.PageTransformer {

    private ViewPager.PageTransformer mPageTransformer = NonPageTransfrom.NO_PAGE_TRANSFER;

    @Override
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void transformPage(View page, float position) {
        if (mPageTransformer != null) mPageTransformer.transformPage(page, position);
        pageTransformer(page, position);
    }

    protected void pageTransformer(View page, float position) {

    }


}
