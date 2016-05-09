package com.example.e.androidwidget.recyler_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e.androidwidget.R;
import com.example.quickdev.OnRecylerViewItemClickLisenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by e on 2016/4/13.
 */
public class RecylerViewTestAty extends AppCompatActivity {

    private RecyclerView mRecylerView;
    List<String> list;
    private OnRecylerViewItemClickLisenter mLisenter;
    private List<Integer> mHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recylerview);
        mRecylerView = (RecyclerView) findViewById(R.id.recylerView);
        mHeight = new ArrayList<Integer>();
//        mRecylerView.setLayoutManager(new LinearLayoutManager(this));
        mRecylerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecylerView.setItemAnimator(new DefaultItemAnimator());
        list = new ArrayList<String>();
        for (int i = 'A'; i <= 'Z'; i++) {
            list.add((char) i + "");
        }
        for (int i = 0; i < 50; i++) {
            list.add(i + "");
        }
        for (int i = 0; i <= list.size(); i++) {
            mHeight.add(getRandomHeight());
        }
//        mRecylerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
//        mRecylerView.addItemDecoration(new DividerGridItemDecoration(this));
        mRecylerView.setAdapter(new MyAdapter());
        setmLisenter(new OnRecylerViewItemClickLisenter() {
            @Override
            public void onItemClick(View view, int pos) {
                Toast.makeText(RecylerViewTestAty.this, list.get(pos), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int pos) {

            }
        });
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(View.inflate(RecylerViewTestAty.this, R.layout.item_recyler, null));
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
//            holder.itemView.setMinimumHeight(getRandomHeight());
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) holder.txt.getLayoutParams();
            params.height = mHeight.get(position);
            holder.txt.setLayoutParams(params);

            holder.txt.setText(list.get(position));
            if (mLisenter != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mLisenter.onItemClick(holder.itemView, position);
                    }
                });
                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        mLisenter.onItemLongClick(holder.itemView, position);
                        return false;
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }
    }


    private int getRandomHeight() {
        boolean isPositive = new Random().nextBoolean();
//        return isPositive ? (200 + new Random().nextInt(100)) : 200 - new Random().nextInt(100);
        return 300 + new Random().nextInt(100) * (isPositive ? 1 : -1);
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt;
        View itemView;

        public MyViewHolder(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.txt_recyler);
            this.itemView = itemView;

        }
    }


    public void setmLisenter(OnRecylerViewItemClickLisenter mLisenter) {
        this.mLisenter = mLisenter;
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }

}
