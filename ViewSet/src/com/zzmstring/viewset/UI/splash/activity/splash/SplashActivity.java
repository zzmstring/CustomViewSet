package com.zzmstring.viewset.UI.splash.activity.splash;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.zzmstring.viewset.R;
import com.zzmstring.viewset.UI.splash.SuccessLaunchActivity;
import com.zzmstring.viewset.UI.splash.utils.AnimationUtil;


public class SplashActivity extends Activity {

	private static final long DELAY_TIME = 3000L;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		redirectByTime();
	}

	private void redirectByTime() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				startActivity(new Intent(SplashActivity.this,SuccessLaunchActivity.class));
				AnimationUtil.finishActivityAnimation(SplashActivity.this);
			}
		}, DELAY_TIME);
	}
}
