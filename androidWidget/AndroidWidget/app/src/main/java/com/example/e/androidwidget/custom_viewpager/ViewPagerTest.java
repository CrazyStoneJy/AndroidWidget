package com.example.e.androidwidget.custom_viewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Scroller;

import com.example.e.androidwidget.R;
import com.example.utils.ScreenUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by e on 2016/5/9.
 */
public class ViewPagerTest extends AppCompatActivity {

    private int[] img_array = {R.mipmap.img1, R.mipmap.img2, R.mipmap.img3, R.mipmap.img4, R.mipmap.img5, R.mipmap.img6, R.mipmap.img7, R.mipmap.img8};
    private ViewPager mViewpager;
    private List<ImageView> mViewList;
    private PagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        initData();
        mViewpager.setOffscreenPageLimit(img_array.length);
        mViewpager.setPageMargin((int) ScreenUtils.dp2px(this, 15f));
        mAdapter = new MyPagerAdapter();
        mViewpager.setAdapter(mAdapter);
//        mViewpager.setPageTransformer(true, new RotationYPageTransform());
        setViewpager(mViewpager,200);
        mViewpager.setPageTransformer(true, new CustomPageTransform());
    }

    private void initData() {
        if (mViewList == null) mViewList = new ArrayList<>();
        for (int resid : img_array) {
            ImageView imgView = new ImageView(this);
            imgView.setScaleType(ImageView.ScaleType.FIT_XY);
            imgView.setImageResource(resid);
            mViewList.add(imgView);
        }
    }


    private void setViewpager(ViewPager viewPager, int duration) {
        Class cls = viewPager.getClass();
        if (cls.isInstance(ViewPager.class)) {
            try {
                Field fScroller = cls.getDeclaredField("mScroller");
                Field fDuration = cls.getDeclaredField("mDuration");
                fScroller.setAccessible(true);
                fDuration.setAccessible(true);
                Scroller scroller = new Scroller(this, new AccelerateDecelerateInterpolator());
                fScroller.set(viewPager, scroller);
                fDuration.set(viewPager, duration);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return img_array.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        String[] array = getResources().getStringArray(R.array.viewpager_str_array);
        for (String str : array) {
            menu.add(str);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String title = item.getTitle().toString();
        mViewpager.setAdapter(mAdapter);
        if (title.equals("alpha")) {
            mViewpager.setPageTransformer(true, new AlphaPageTransform());
        } else if (title.equals("rotationY")) {
            mViewpager.setPageTransformer(true, new RotationYPageTransform());
        } else if (title.equals("Scale")) {
            mViewpager.setPageTransformer(true, new ScalePageTransform());
        } else if (title.equals("alpha and Scale")) {
            mViewpager.setPageTransformer(true, new ScalePageTransform(new AlphaPageTransform()));
        } else {
            mViewpager.setPageTransformer(true, new ScalePageTransform(new AlphaPageTransform(new ScalePageTransform())));
        }

        setTitle(title);
        return true;
    }
}
