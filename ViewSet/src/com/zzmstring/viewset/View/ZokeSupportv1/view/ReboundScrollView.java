package com.zzmstring.viewset.View.ZokeSupportv1.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * 反弹效果的ScrollView
 * 
 * @author JackWu
 * @version 1.0
 * @date 2014-10-21
 * @_QQ_ 651319154
 */
public class ReboundScrollView extends ScrollView {
	private static final int MSG_REST_POSITION = 0x01;
	private static final int MSG_LISTEN_SCROLL = 0x02;

	/** The max scroll height. */
	private static final int MAX_SCROLL_HEIGHT = 400;
	/** Damping, the smaller the greater the resistance */
	private static final float SCROLL_RATIO = 0.4f;

	private View mChildRootView;

	private ReboundScrollListener mListener;

	private float mTouchY;
	private boolean mTouchStop = false;

	private int mScrollY = 0;
	private int mScrollDy = 0;

	private final Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (MSG_REST_POSITION == msg.what) {
				if (mScrollY != 0 && mTouchStop) {
					mScrollY -= mScrollDy;

					if ((mScrollDy < 0 && mScrollY > 0)
							|| (mScrollDy > 0 && mScrollY < 0)) {
						mScrollY = 0;
					}

					mChildRootView.scrollTo(0, mScrollY);
					// continue scroll after 20ms
					sendEmptyMessageDelayed(MSG_REST_POSITION, 20);
				}
			}
			/** 监听 **/
			if (MSG_LISTEN_SCROLL == msg.what) {
				if (mListener != null) {
					mListener.onLinstener();
				}
			}
		}
	};

	public ReboundScrollView(Context context) {
		super(context);

		init();
	}

	public ReboundScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);

		init();
	}

	public ReboundScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		init();
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		super.onLayout(changed, l, t, r, b);
	}

	@SuppressLint("NewApi")
	private void init() {
		setOverScrollMode(OVER_SCROLL_NEVER);
	}

	@Override
	protected void onFinishInflate() {
		if (getChildCount() > 0) {
			// when finished inflating from layout xml, get the first child view
			mChildRootView = getChildAt(0);
		}
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {// 复写父类方法，子view不占满整个屏幕也可以滑动，by_dsr
		if (ev.getAction() == MotionEvent.ACTION_DOWN) {// 修改前在onInterceptTouchEvent方法中
			mTouchY = ev.getY();
		}
		if (null != mChildRootView) {// 修改前在ontouchEvent方法中
			doTouchEvent(ev);
		}
		return super.dispatchTouchEvent(ev);
	}

	private void doTouchEvent(MotionEvent ev) {
		int action = ev.getAction();
		switch (action) {
		case MotionEvent.ACTION_UP:
			mScrollY = mChildRootView.getScrollY();
			if (mScrollY != 0) {
				mTouchStop = true;
				mScrollDy = (int) (mScrollY / 10.0f);
				mHandler.sendEmptyMessage(MSG_REST_POSITION);
			}
			int scrolly = mScrollY;
			// TODO:监听方法的暂时解决方案
			if (-scrolly > getHeight() / 4) {
				mHandler.sendEmptyMessageDelayed(MSG_LISTEN_SCROLL, 180);
			}

			break;

		case MotionEvent.ACTION_MOVE:
			float nowY = ev.getY();
			int deltaY = (int) (mTouchY - nowY);
			mTouchY = nowY;
			if (isNeedMove()) {
				int offset = mChildRootView.getScrollY();
				if (offset < MAX_SCROLL_HEIGHT && offset > -MAX_SCROLL_HEIGHT) {
					mChildRootView.scrollBy(0, (int) (deltaY * SCROLL_RATIO));
					mTouchStop = false;
				}
			}

			break;

		default:
			break;
		}
	}

	private boolean isNeedMove() {
		int viewHeight = mChildRootView.getMeasuredHeight();
		int scrollHeight = getHeight();
		int offset = viewHeight - scrollHeight;
		int scrollY = getScrollY();

		return scrollY == 0 || scrollY == offset;
	}

	/** 设置反弹滑动监听 **/
	public void setReboundScrollListener(ReboundScrollListener listener) {
		this.mListener = listener;
	}

	/** 反弹下滑时的监听 **/
	public interface ReboundScrollListener {
		void onLinstener();
	}
}