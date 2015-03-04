package com.zzmstring.viewset.View.ZokeSupportv1.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 自定义TextView
 * 
 * @author JackWu
 * 
 */
public class ZokeTextView extends TextView {
	public ZokeTextView(Context context) {
		super(context);
	}

	public ZokeTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ZokeTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public boolean isInEditMode() {
		return true;
	}

	@Override
	public void setText(CharSequence text, BufferType type) {
		if (text == null) {
			text = "";
		}
		super.setText(text, type);
	}
}
