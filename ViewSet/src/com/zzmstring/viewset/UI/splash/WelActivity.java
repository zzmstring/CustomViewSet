package com.zzmstring.viewset.UI.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.UI.splash.activity.scrollView.ScollerViewActivity;
import com.zzmstring.viewset.UI.splash.activity.splash.SplashActivity;
import com.zzmstring.viewset.UI.splash.activity.viewFlipper.ViewFlipperActivity;
import com.zzmstring.viewset.UI.splash.activity.viewPage.ViewPagerActivity;
import com.zzmstring.viewset.UI.splash.utils.AnimationUtil;

/**
 * Created by ZGL on 2015/3/6.
 */
public class WelActivity  extends BaseActivity{
    @ViewInject(R.id.btnSplash)
    private Button btnSplash;
    @ViewInject(R.id.btnViewPage)
    private Button btnViewPage;
    @ViewInject(R.id.btnViewFlipper)
    private Button btnViewFlipper;
    @ViewInject(R.id.btnScrollView)
    private Button btnScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_welmain);
        ViewUtils.inject(this);
    }

    @Override
    public void initListener() {
        btnSplash.setOnClickListener(this);
        btnViewPage.setOnClickListener(this);
        btnViewFlipper.setOnClickListener(this);
        btnScrollView.setOnClickListener(this);

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        if(v==btnSplash){
            startActivity(new Intent(this,SplashActivity.class));
        }else if(v==btnViewPage){
            startActivity(new Intent(this,ViewPagerActivity.class));
        }else if(v==btnViewFlipper){
            startActivity(new Intent(this,ViewFlipperActivity.class));
        }else if(v==btnScrollView){
            startActivity(new Intent(this,ScollerViewActivity.class));
        }
        AnimationUtil.activityZoomAnimation(this);
    }
}
