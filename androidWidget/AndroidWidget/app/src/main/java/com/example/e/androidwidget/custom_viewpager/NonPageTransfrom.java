package com.example.e.androidwidget.custom_viewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by e on 2016/5/9.
 */
public class NonPageTransfrom implements ViewPager.PageTransformer {

    public static final ViewPager.PageTransformer NO_PAGE_TRANSFER=new NonPageTransfrom();
    @Override
    public void transformPage(View page, float position) {

    }
}
