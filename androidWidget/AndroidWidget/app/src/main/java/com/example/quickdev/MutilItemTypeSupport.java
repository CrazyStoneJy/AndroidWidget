package com.example.quickdev;

/**
 * Created by e on 2016/4/19.
 */
public interface MutilItemTypeSupport<DATA> {

    int getLayoutId(int itemType);

    int getViewTypeCount();

    int getItemViewType(int position, DATA data);

}
