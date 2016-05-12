package com.example.e.androidwidget.flowlayout.customviewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crazystone on 2016/5/12.
 */
public class FlowLayout extends ViewGroup {

    private Context mContext;
    /* 所有childview的list  */
    private List<List<View>> mAllViewList = new ArrayList<>();
    /* 记录每一行的最大值   */
    private List<Integer> mHeightList = new ArrayList<>();

    public FlowLayout(Context context) {
        super(context);
        this.mContext = context;
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }

    //测量该viewGroup的宽高
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        /*  计算的parent的实际高度 */
        int height = 0;
        /*  计算的parent的实际宽度  */
        int width = 0;
        /*  每一行累加的宽度  */
        int lineWidth = 0;
        /*  累加的高度  */
        int lineHeight = 0;

        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            //测量child View的高度和宽度
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            //child的高度和宽度，考虑child的margin
            int childWidth = child.getWidth() + lp.leftMargin + lp.rightMargin;
            int childHeight = child.getWidth() + lp.topMargin + lp.bottomMargin;

            //如果加入当前child，则超出最大宽度，则的到目前最大宽度给width，类加height 然后开启新行
            if (childWidth + lineWidth > widthSize) {
                width = Math.max(childWidth, lineWidth);
                lineWidth = childWidth;
                height += lineHeight;
                lineHeight = childHeight;
            } else {// 否则累加值lineWidth,lineHeight取最大高度
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, childHeight);
            }
            // 如果是最后一个，则将当前记录的最大宽度和当前lineWidth做比较
            if (i == count - 1) {
                width = Math.max(lineWidth, childWidth);
                height += lineHeight;
            }
        }
        setMeasuredDimension(widthMode == MeasureSpec.EXACTLY ? widthSize : width, heightMode == MeasureSpec.EXACTLY ? heightSize : height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mAllViewList.clear();
        mHeightList.clear();

        int width = getWidth();
        int lineWidth = 0;
        int lineHeight = 0;
        int count = getChildCount();
        //用来存放每一行的view
        List<View> viewList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getWidth() + lp.leftMargin + lp.rightMargin;
            int childHeight = child.getHeight() + lp.topMargin + lp.bottomMargin;
            if (childWidth + lineWidth > width) {
                mHeightList.add(lineHeight);
                mAllViewList.add(viewList);
                lineWidth = 0;
                viewList = new ArrayList<>();
            } else {
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, childHeight);
                viewList.add(child);
            }
        }
        //记录最后一行
        mHeightList.add(lineHeight);
        mAllViewList.add(viewList);

        int top = 0;
        int left = 0;
        int lineNumber = mAllViewList.size();
        for (int i = 0; i < lineNumber; i++) {
            // 每一行的所有的views
           viewList = mAllViewList.get(i);
            lineHeight = mHeightList.get(i);
            for (int j = 0; j < viewList.size(); j++) {
                View child = viewList.get(j);
                if (child.getVisibility() == View.GONE) {
                    continue;
                }
                MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
                int cl = left + lp.leftMargin;
                int ct = top + lp.topMargin;
                int cr = cl + child.getMeasuredWidth();
                int cb = ct + child.getMeasuredHeight();
                child.layout(cl, ct, cr, cb);
                left += child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            }
            left = 0;
            top += lineHeight;
        }
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(mContext, attrs);
    }
}
