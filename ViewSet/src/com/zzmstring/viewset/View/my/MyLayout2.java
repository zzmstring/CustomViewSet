package com.zzmstring.viewset.View.my;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/**
 * Created by zzmstring on 2015/5/12.
 */
public class MyLayout2 extends FrameLayout {
    private ViewDragHelper dragHelper;
    private int range;
    private Context context;
    private RelativeLayout topView;
    private RelativeLayout contentView;
    private Status status = Status.Close;

    public MyLayout2(Context context) {
        this(context, null);
    }
    public MyLayout2(Context context,AttributeSet attributeSet){
        this(context, attributeSet, 0);
        this.context = context;
    }
    public MyLayout2(Context context,AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        dragHelper = ViewDragHelper.create(this, dragHelperCallback);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() < 2) {
            throw new RuntimeException("Content view must contains two child views at least.");
        }
        topView= (RelativeLayout) getChildAt(0);
        contentView= (RelativeLayout) getChildAt(1);
    }
    @Override
    public void computeScroll() {

        if (dragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private ViewDragHelper.Callback dragHelperCallback=new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(View view, int i) {
            return false;
        }
        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return 0;
        }
        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);

        }
        @Override
        public void onViewPositionChanged(View changedView, int left, int top,
                                          int dx, int dy) {

        }
    };
    public enum Status {
         Open, Close
    }
}
