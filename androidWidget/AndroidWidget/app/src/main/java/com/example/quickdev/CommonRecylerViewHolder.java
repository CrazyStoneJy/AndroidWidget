package com.example.quickdev;

import android.content.ComponentName;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

/**
 * Created by e on 2016/4/19.
 */
public class CommonRecylerViewHolder extends RecyclerView.ViewHolder {

    private Context mContext;
    private View mItemView;
    private SparseArray<View> mViewMap;


    public CommonRecylerViewHolder(Context mContext, View itemView, ViewGroup parent) {
        super(itemView);
        this.mItemView = itemView;
        this.mContext = mContext;
        mViewMap = new SparseArray<View>();
    }


    public static CommonRecylerViewHolder getViewHolder(Context context, int layoutId, ViewGroup parent) {
        View convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        CommonRecylerViewHolder holder = new CommonRecylerViewHolder(context, convertView, parent);
        return holder;
    }

    /**
     * 通过viewId获取view
     *
     * @param viewId
     * @return
     */
    public <VIEW extends View> VIEW getView(int viewId) {
        View view =null;
        if (viewId == 0) return null;
        view=mViewMap.get(viewId);
        if (view == null) {
            view = mItemView.findViewById(viewId);
            mViewMap.put(viewId, view);
        }
        return (VIEW) view;
    }

}
