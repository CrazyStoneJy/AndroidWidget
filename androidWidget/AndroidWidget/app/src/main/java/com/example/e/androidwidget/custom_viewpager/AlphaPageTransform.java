package com.example.e.androidwidget.custom_viewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by e on 2016/5/9.
 */
public class AlphaPageTransform extends CommonPageTransform {

    private static final float DEFALUT_APHLA = 0.4f;
    private float mAphla = DEFALUT_APHLA;
    private ViewPager.PageTransformer mPageTransFormer;

    public AlphaPageTransform(float alpha) {
        this(NonPageTransfrom.NO_PAGE_TRANSFER, alpha);
    }

    public AlphaPageTransform(ViewPager.PageTransformer pageTransformer) {
        this(pageTransformer, DEFALUT_APHLA);
    }

    public AlphaPageTransform(ViewPager.PageTransformer pageTransformer, float alpha) {
        this.mAphla = alpha;
        this.mPageTransFormer = pageTransformer;
    }

    @Override
    protected void pageTransformer(View page, float position) {
        if (position < -1) {
            page.setAlpha(mAphla);
        } else if (position < 1) {
            if (position > 0) {
//                float currentAlpha=mAphla+(1-mAphla)*(1+position);
                page.setAlpha(mAphla + (1 - mAphla) * (1 + position));
            } else {
                page.setAlpha(mAphla + (1 - mAphla) * (1 - position));
            }
        } else {
            page.setAlpha(mAphla);
        }
    }
}
