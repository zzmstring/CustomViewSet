package com.zzmstring.viewset.View.ZokeSupportv1.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zzmstring.viewset.R;


/**
 * 自定义土司
 * 
 * @author JackWu
 * 
 */
public class ZokeToast {

	private static Toast makeText(Context context, int resource,
			CharSequence text, int duration) {
		Toast result = new Toast(context);
		// 获取LayoutInflater对象
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// 由layout文件创建一个View对象
		View layout = inflater.inflate(R.layout.zk_custom_toast, null);
		// 实例化ImageView和TextView对象
		ImageView imageView = (ImageView) layout
				.findViewById(R.id.customImage_Iv);
		TextView textView = (TextView) layout.findViewById(R.id.customText_Tv);
		if (resource == 0) {
			imageView.setVisibility(View.GONE);
		} else {
			imageView.setVisibility(View.VISIBLE);
			imageView.setImageResource(resource);
		}

		textView.setText(text);
		result.setView(layout);
		// 设置显示位置
		// result.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		result.setDuration(duration);
		return result;
	}

	/** shortToast 单文字显示 **/
	public static void show(Context context, CharSequence text) {
		makeText(context, 0, text, Toast.LENGTH_SHORT).show();
	}

	/** shortToast 单文字显示 **/
	public static void showNetFailed(Context context) {
		makeText(context, 0, "网络不给力哦", Toast.LENGTH_SHORT).show();
	}

	/** shortToast 图文显示 **/
	public static void show(Context context, CharSequence text, int resource) {
		makeText(context, resource, text, Toast.LENGTH_SHORT).show();
	}

}
