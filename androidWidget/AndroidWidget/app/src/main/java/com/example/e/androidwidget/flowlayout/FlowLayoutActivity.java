package com.example.e.androidwidget.flowlayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.e.androidwidget.R;

/**
 * Created by crazystone on 2016/5/11.
 */
public class FlowLayoutActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private String[] mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowlayout);

        mTabLayout = (TabLayout) findViewById(R.id.flow_activity_tab);
        mViewPager = (ViewPager) findViewById(R.id.flow_activity_viewpager);
        mTab = getResources().getStringArray(R.array.flowlayout_tab);
        setViewPagerFragment();
    }

    private void setViewPagerFragment() {
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new FragmentTest1();
                    case 1:
                        return new FragmentTest2();
                    case 2:
                        return new FragmentTest3();
                    case 3:
                        return new FragmentTest4();
                    default:
                        return new FragmentTest1();
                }
            }

            @Override
            public int getCount() {
                return mTab.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTab[position];
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
    }

}
