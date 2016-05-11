package com.example.e.androidwidget.flowlayout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e.androidwidget.R;

/**
 * Created by crazystone on 2016/5/11.
 */
public class FragmentTest1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View convertView=View.inflate(getActivity(),R.layout.frag_test1,null);
        return convertView;
    }
}
