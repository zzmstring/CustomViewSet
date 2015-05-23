package com.zzmstring.viewset.View.my;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.zzmstring.viewset.Utils.ExLog;

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
    private boolean shouldIntercept = true;
    private int topViewHeight;
    private int dragRange;
    private int contentTop;
    private int topViewWid;
    private int tempDy;
    public MyLayout2(Context context) {
        this(context, null);
    }

    public MyLayout2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.context = context;
    }
    public MyLayout2(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dragHelper = ViewDragHelper.create(this, 1.0f,dragHelperCallback);
    }
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        dragRange = getHeight();
        topViewHeight = topView.getHeight();
        topViewWid=topView.getWidth();
        contentView.layout(0,contentTop,topViewWid,contentTop+dragRange);
        topView.layout(0,0-topViewHeight/2+contentTop/2,topViewWid,topViewHeight/2+contentTop/2);
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() < 2) {
            throw new RuntimeException("Content view must contains two child views at least.");
        }
        topView = (RelativeLayout) getChildAt(0);
        contentView = (RelativeLayout) getChildAt(1);
    }
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        try {
            dragHelper.processTouchEvent(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }
    @Override
    public void computeScroll() {
        if (dragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            boolean intercept = shouldIntercept && dragHelper.shouldInterceptTouchEvent(ev);
            return intercept;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }
    private ViewDragHelper.Callback dragHelperCallback = new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(View view, int i) {
            if (view == topView) {
                dragHelper.captureChildView(contentView, i);
                return false;
            }
            return view == contentView;
        }
        @Override
        public int getViewVerticalDragRange(View child) {
            return dragRange;
        }
        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return 0;
        }
        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
//            ExLog.l(ExLog.getCurrentMethodName()+Math.min(topViewHeight, Math.max(top, getPaddingTop())));
            tempDy=dy;
            ExLog.l("dy="+dy);
            return Math.min(topViewHeight, Math.max(top, getPaddingTop()));
        }
        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
            int top = 0;
            ExLog.l("yvel="+yvel);
            if (yvel > 0 ||tempDy > 0) {
                ExLog.l("contenttop="+contentTop);
                top = topViewHeight + getPaddingTop();
            }else if(yvel < 0||tempDy <= 0){
                top = getPaddingTop();
            }else {
                top = contentTop > topViewHeight/2 ? topViewHeight + getPaddingTop() : getPaddingTop();
            }
//            ExLog.l(ExLog.getCurrentMethodName()+top);
            dragHelper.settleCapturedViewAt(releasedChild.getLeft(), top);
            postInvalidate();
        }
        @Override
        public void onViewPositionChanged(View changedView, int left, int top,
                                          int dx, int dy) {
            contentTop = top;
//            ExLog.l(ExLog.getCurrentMethodName()+top);
            requestLayout();
        }
        @Override
        public void onViewDragStateChanged(int state) {
//            ExLog.l(ExLog.getCurrentMethodName());
            // 1 -> 2 -> 0
            if (state == ViewDragHelper.STATE_IDLE) {
                // Change the panel state while the drag content view is idle.
                if (contentTop == getPaddingTop() ) {
                    status = Status.Close;
                } else {
                    status = Status.Open;
                }
            } else {
                status = Status.Sliding;
            }
            super.onViewDragStateChanged(state);
        }
    };

    public enum Status {
        Open, Close,Sliding
    }
}
