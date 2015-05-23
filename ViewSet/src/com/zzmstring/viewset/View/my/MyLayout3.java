package com.zzmstring.viewset.View.my;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.zzmstring.viewset.Utils.ExLog;

/**
 * Created by zzmstring on 2015/5/12.
 */
public class MyLayout3 extends FrameLayout {
    private ViewDragHelper dragHelper;
    private int range;
    private Context context;
    private RelativeLayout topView;
    private ObservableScrollView  contentView;
    private Status status =Status.Close;
    private boolean shouldIntercept = true;
    private int topViewHeight;
    private int dragRange;
    private int contentTop;
    private int topViewWid;
    private int tempDy;
    private int scrollY;
    private float lastY=0;
    private float hahaY=0;

    public MyLayout3(Context context) {
        this(context, null);
    }

    public MyLayout3(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.context = context;
    }

    public MyLayout3(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dragHelper = ViewDragHelper.create(this, 1.0f,dragHelperCallback);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
//        ExLog.l(ExLog.getCurrentMethodName());
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
        contentView = (ObservableScrollView ) getChildAt(1);
        contentView.setScrollViewListener(new ScrollViewListener() {
            @Override
            public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
                ExLog.l("x="+x+" y="+y+" oldx="+oldx+" oldy="+oldy);
                scrollY=y;
            }
        });
        contentView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_MOVE){
                    float curY=motionEvent.getY();
                    ExLog.l("hahah"+(curY-lastY));
                    hahaY=curY-lastY;
                    lastY=curY;

                }
                return false;
            }
        });
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
            ExLog.l("scrollY="+scrollY);
//            if(status==Status.Close){
//                ExLog.l("oninter  close");
//                if(scrollY==0){
//                    return true;
//                }else {
//                    return false;
//                }
//
//            }
            if(scrollY==0){
                if(tempDy<=-1){
                    if(hahaY>0){
                        ExLog.l("拦截");
                        return true;
                    }
                    ExLog.l("未拦截");
                    return false;
                }else {
                    ExLog.l("拦截");
                    return true;
                }
            }

            boolean intercept = shouldIntercept && dragHelper.shouldInterceptTouchEvent(ev);
            ExLog.l("拦截的是"+intercept);
            return false;
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
            hahaY=dy;
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
