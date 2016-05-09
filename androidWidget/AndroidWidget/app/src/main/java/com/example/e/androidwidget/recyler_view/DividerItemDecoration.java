package com.example.e.androidwidget.recyler_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.midi.MidiDeviceInfo;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by e on 2016/4/19.
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private static final int HORIZONTAL = LinearLayoutManager.HORIZONTAL;
    private static final int VERTICAL = LinearLayoutManager.VERTICAL;
    private static final int[] ATTR = new int[]{android.R.attr.listDivider};
    private Drawable mDivider;
    private Context mContext;
    private int mOrientation;


    public DividerItemDecoration(Context context, int orientation) {
        this.mContext = context;
        this.mOrientation = orientation;
        TypedArray typedArray = context.obtainStyledAttributes(ATTR);
        mDivider = typedArray.getDrawable(0);
        typedArray.recycle();

    }


    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL) {
            drawVertical(c, parent);
        } else if (mOrientation == HORIZONTAL) {
            drawHorizontal(c, parent);
        } else {
            throw new RuntimeException("invalidate orientation");
        }
    }

    /***
     * 若layoutManager的orientation是横向的，则画横向的分割线
     *
     * @param canvas
     * @param recyclerView
     */
    private void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        final int top = recyclerView.getPaddingTop();
        final int bottom = recyclerView.getWidth() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childView.getLayoutParams();
            final int left = childView.getRight() + params.rightMargin;
            final int right = left + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(canvas);
        }
    }

    /***
     * 若layoutManager的orientation是纵向的，则画纵向的分割线
     *
     * @param canvas
     * @param recyclerView
     */
    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        final int left = recyclerView.getPaddingLeft();
        final int right = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childView.getLayoutParams();
            final int top = childView.getBottom() + params.bottomMargin;
            final int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(canvas);
        }
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL) {
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        } else if (mOrientation == HORIZONTAL) {
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }
    }
}
