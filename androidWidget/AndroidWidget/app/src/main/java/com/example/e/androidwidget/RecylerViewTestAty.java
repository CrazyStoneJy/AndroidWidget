package com.example.e.androidwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e on 2016/4/13.
 */
public class RecylerViewTestAty extends AppCompatActivity {

    private RecyclerView mRecylerView;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recylerview);
        mRecylerView = (RecyclerView) findViewById(R.id.recylerView);
        mRecylerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<String>();
        for (int i = 'A'; i <= 'Z'; i++) {
            list.add((char) i + "");
        }
        mRecylerView.setAdapter(new MyAdapter());
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(View.inflate(RecylerViewTestAty.this, R.layout.item_recyler, null));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.txt.setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt;

        public MyViewHolder(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.txt_recyler);
        }
    }

}
