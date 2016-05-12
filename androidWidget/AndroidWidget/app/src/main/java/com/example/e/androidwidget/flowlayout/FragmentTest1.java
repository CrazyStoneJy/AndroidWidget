package com.example.e.androidwidget.flowlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.e.androidwidget.R;
import com.example.e.androidwidget.flowlayout.customviewgroup.FlowLayout;

/**
 * Created by crazystone on 2016/5/11.
 */
public class FragmentTest1 extends Fragment {

    private FlowLayout flowLayout;
    private String[] array = {"hello", "hangdongtang", "crazystone", "shabi", "nimei",
            "hello", "hangdongtang", "crazystone", "shabi", "nimei",
            "hello", "hangdongtang", "crazystone", "shabi", "nimei"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View convertView = inflater.inflate( R.layout.frag_test1, null);
        flowLayout = (FlowLayout) convertView.findViewById(R.id.flowlayout_test1);
//        for (String str : array) {
//            TextView txt = new TextView(getActivity());
////            ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(getActivity(), null);
////            lp.leftMargin = (int) ScreenUtils.dp2px(getActivity(), 10);
////            lp.rightMargin = (int) ScreenUtils.dp2px(getActivity(), 10);
////            txt.setLayoutParams(lp);
//            txt.setTextSize((int) ScreenUtils.dp2px(getActivity(), 20));
//            txt.setText(str);
//            flowLayout.addView(txt);
//        }

        return convertView;
    }
}
