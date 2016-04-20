package com.example.e.androidwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.quickdev.CommonRecylerViewAdapter;
import com.example.quickdev.CommonRecylerViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e on 2016/4/19.
 */
public class Test1 extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mDataList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recylerview);
        mRecyclerView = (RecyclerView) findViewById(R.id.recylerView);

        for (int i = 'A'; i <= 'Z'; i++) {
            mDataList.add((char) i + "");
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new CommonRecylerViewAdapter<String>(this, R.layout.item_recyler, mDataList) {
            @Override
            protected void convert(CommonRecylerViewHolder holder, String s) {
                TextView txt = holder.getView(R.id.txt_recyler);
                txt.setText(s);
            }
        });
    }
}
