package com.zzmstring.viewset.UI.splash.activity.scrollView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.UI.splash.SuccessLaunchActivity;
import com.zzmstring.viewset.UI.splash.utils.AnimationUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ScollerViewActivity extends Activity implements
		OnScrollChangedListener {
	@ViewInject(R.id.ll_anim)
	private LinearLayout mLLAnim;
	private MyScrollView mSVmain;
	private int mScrollViewHeight;
	private int mStartAnimateTop;
	private boolean hasStart = false;
	@ViewInject(R.id.tvInNew)
	private TextView tvInNew;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scrollview);
		ViewUtils.inject(this);
		initView();
		setView();
	}

	private void initView() {
		mSVmain = (MyScrollView) findViewById(R.id.sv_main);
		tvInNew.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(ScollerViewActivity.this,SuccessLaunchActivity.class));
				AnimationUtil.finishActivityAnimation(ScollerViewActivity.this);
			}
		});
	}

	private void setView() {
		mSVmain.setOnScrollChangedListener(this);
		mLLAnim.setVisibility(View.INVISIBLE);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		mScrollViewHeight = mSVmain.getHeight();
		mStartAnimateTop = mScrollViewHeight / 5 * 4;// �ھ���ScrollView����mStartAnimateTop����ĵط���ʼ���ض���
	}

	@Override
	public void onScrollChanged(int top, int oldTop) {
		int animTop = mLLAnim.getTop() - top;// ���mLLAnim�ؼ���ScrollView���ӽ��涥���ľ���
		if (top > oldTop) {// ���ϻ���
			if (animTop < mStartAnimateTop && !hasStart) {// ��mLLAnim�����ӽ���Ķ����߶�С���������õĸ߶ȣ���ʼ���ض���
				Animation anim = AnimationUtils
						.loadAnimation(this, R.anim.show);
				mLLAnim.setVisibility(View.VISIBLE);
				mLLAnim.startAnimation(anim);
				hasStart = true;
			}
		} else {// ���»���
			if (animTop > mStartAnimateTop && hasStart) {
				Animation anim = AnimationUtils.loadAnimation(this,
						R.anim.close);
				mLLAnim.setVisibility(View.INVISIBLE);
				mLLAnim.startAnimation(anim);
				hasStart = false;
			}
		}
	}

}
