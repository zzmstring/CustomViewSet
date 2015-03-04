package com.zzmstring.viewset.View.ZokeSupportv1.view;

import android.app.Dialog;
import android.content.Context;

import com.zzmstring.viewset.R;


/**
 * 进度条
 * 
 * @author JackWu
 * @version
 * @date 2014-11-17
 * @_QQ_ 651319154
 */
public class FlippingLoadingDialog extends Dialog {

	protected FlippingImageView mFivIcon;
	private ZokeTextView mHtvText;
	private String mText;

	public FlippingLoadingDialog(Context context, String text) {
		super(context, R.style.basedialog);
		setCancelable(false);
		mText = text;
		init();
	}

	private void init() {
		setContentView(R.layout.view_flippingloading);
		mFivIcon = (FlippingImageView) findViewById(R.id.loadingdialog_fiv_icon);
		mHtvText = (ZokeTextView) findViewById(R.id.loadingdialog_htv_text);
		mFivIcon.startAnimation();
		mHtvText.setText(mText);
	}

	public void setText(String text) {
		mText = text;
		mHtvText.setText(mText);
	}

	@Override
	public void dismiss() {
		if (isShowing()) {
			super.dismiss();
		}
	}
}
