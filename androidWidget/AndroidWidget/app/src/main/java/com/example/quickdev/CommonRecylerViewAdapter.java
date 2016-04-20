package com.example.quickdev;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by e on 2016/4/19.
 */
public abstract class CommonRecylerViewAdapter<DATA> extends RecyclerView.Adapter<CommonRecylerViewHolder> {

    protected Context mContext;
    protected int mLayoutId;
    protected List<DATA> mDataList;
    protected OnRecylerViewItemClickLisenter mLisenter;

    public CommonRecylerViewAdapter(Context mContext, int mLayoutId, List<DATA> mDataList) {
        this.mContext = mContext;
        this.mLayoutId = mLayoutId;
        this.mDataList = mDataList;
    }

    @Override
    public void onBindViewHolder(CommonRecylerViewHolder holder, int position) {
        setLisenter(holder, position, holder.getItemViewType());
        convert(holder, mDataList.get(position));
    }

    public void setLisenter(final CommonRecylerViewHolder holder, final int position, final int viewType) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLisenter != null) mLisenter.onItemClick(holder.itemView, position);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mLisenter != null) mLisenter.onItemLongClick(holder.itemView, position);
                return false;
            }
        });
    }


    protected void convert(CommonRecylerViewHolder holder, DATA data) {

    }

    @Override
    public int getItemCount() {
        return mDataList != null ? mDataList.size() : 0;
    }

    @Override
    public CommonRecylerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mLayoutId == -1) return null;
        CommonRecylerViewHolder holder = CommonRecylerViewHolder.getViewHolder(mContext, mLayoutId, parent);
        return holder;
    }


    public void setRecylerViewItemClickLisenter(OnRecylerViewItemClickLisenter mLisenter) {
        this.mLisenter = mLisenter;
    }
}
