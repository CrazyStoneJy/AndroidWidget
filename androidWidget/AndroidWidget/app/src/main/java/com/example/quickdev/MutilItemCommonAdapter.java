package com.example.quickdev;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by e on 2016/4/19.
 */
public abstract class MutilItemCommonAdapter<DATA> extends CommonRecylerViewAdapter<DATA> {

    protected MutilItemTypeSupport<DATA> mSupport;

    public MutilItemCommonAdapter(Context mContext, MutilItemTypeSupport support, List<DATA> mDataList) {
        super(mContext, -1, mDataList);
        mSupport = support;
    }


    @Override
    public int getItemViewType(int position) {
        if (mSupport != null)
            return mSupport.getItemViewType(position, mDataList.get(position));
        return super.getItemViewType(position);
    }


    @Override
    public CommonRecylerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mSupport == null)
            return super.onCreateViewHolder(parent, viewType);
        int layoutId = mSupport.getLayoutId(viewType);
        CommonRecylerViewHolder holder = CommonRecylerViewHolder.getViewHolder(mContext, layoutId, parent);
        return holder;
    }
}
