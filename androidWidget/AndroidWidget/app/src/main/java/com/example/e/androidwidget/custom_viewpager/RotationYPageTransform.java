package com.example.e.androidwidget.custom_viewpager;

import android.support.v4.view.ViewPager;
import android.view.View;


/**
 * Created by crazystone on 2016/5/10.
 */
public class RotationYPageTransform extends CommonPageTransform {

    private static final float DEAULT_ANGEL = 15f;
    private ViewPager.PageTransformer mPageTransfromer;
    /*  view的高度  */
    private int pageHeight = 0;
    /*   view的宽度  */
    private int pageWidth = 0;

    public RotationYPageTransform(ViewPager.PageTransformer mPageTransfromer) {
        this.mPageTransfromer = mPageTransfromer;
    }

    public RotationYPageTransform() {
        this(NonPageTransfrom.NO_PAGE_TRANSFER);
    }


    @Override
    protected void pageTransform(View page, float position) {
        float factor = 0;
        pageHeight = page.getHeight();
        pageWidth = page.getWidth();
        page.setPivotY(pageHeight / 2);
        if (position < -1) {
            page.setPivotX(pageWidth);
            page.setRotationY(DEAULT_ANGEL * -1);
        } else if (position < 1) {
            page.setRotationY(DEAULT_ANGEL * position);
            //i don't konw why do this
            if (position <= 0) {
                page.setPivotX(pageWidth);
            } else {
                page.setPivotX(0);
            }
        } else {
            page.setPivotX(0);
            page.setRotationY(DEAULT_ANGEL);
        }
    }
}
