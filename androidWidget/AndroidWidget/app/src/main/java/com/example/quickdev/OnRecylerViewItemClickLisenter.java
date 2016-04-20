package com.example.quickdev;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by e on 2016/4/19.
 */
public interface OnRecylerViewItemClickLisenter {

    public void onItemClick(View view, int pos);

    public void onItemLongClick(View view, int pos);
}
