package com.zzmstring.viewset.UI.every;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.UI.DragTopLayoutActivity;
import com.zzmstring.viewset.UI.QuickReturnActivity;
import com.zzmstring.viewset.UI.WandouIndexActivity;
import com.zzmstring.viewset.UI.every.LayoutAty.LoadViewHelperAty;
import com.zzmstring.viewset.UI.every.LayoutAty.ShadowLayoutAty;
import com.zzmstring.viewset.UI.every.LayoutAty.SwipeBackAty;
import com.zzmstring.viewset.UI.splash.WelActivity;
import com.zzmstring.viewset.UI.zokesupport.ZokeSupportMainActivity;


/**
 * Created by zzmstring on 2015/3/19.
 */
public class ElayoutAty extends BaseActivity {
    @ViewInject(R.id.bt1)
    Button bt1;
    @ViewInject(R.id.bt2)
    Button bt2;
    @ViewInject(R.id.bt3)
    Button bt3;
    @ViewInject(R.id.bt4)
    Button bt4;
    @ViewInject(R.id.bt5)
    Button bt5;
    @ViewInject(R.id.bt6)
    Button bt6;
    @ViewInject(R.id.bt7)
    Button bt7;
    @ViewInject(R.id.bt8)
    Button bt8;
    @ViewInject(R.id.bt9)
    Button bt9;
    @ViewInject(R.id.bt10)
    Button bt10;
    @ViewInject(R.id.bt11)
    Button bt11;
    @ViewInject(R.id.bt12)
    Button bt12;
    @ViewInject(R.id.bt13)
    Button bt13;
    @ViewInject(R.id.bt14)
    Button bt14;
    @ViewInject(R.id.bt15)
    Button bt15;
    @ViewInject(R.id.bt16)
    Button bt16;
    @ViewInject(R.id.bt17)
    Button bt17;
    @ViewInject(R.id.bt18)
    Button bt18;
    @ViewInject(R.id.bt19)
    Button bt19;
    @ViewInject(R.id.bt20)
    Button bt20;
    @ViewInject(R.id.bt21)
    Button bt21;
    @ViewInject(R.id.bt22)
    Button bt22;
    @ViewInject(R.id.bt23)
    Button bt23;
    @ViewInject(R.id.bt24)
    Button bt24;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_every);
        ViewUtils.inject(this);
    }

    @Override
    public void initData() {
        bt1.setText("dragtop");
        bt2.setText("quickre");
        bt3.setText("wandou");
        bt4.setText("welaty");
        bt5.setText("zoke");
        bt6.setText("loadhelper");
        bt7.setText("shadowL");
        bt8.setText("swipeback");
    }

    @Override
    public void initListener() {
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:
                skipActivity(DragTopLayoutActivity.class);
                break;
            case R.id.bt2:
                skipActivity(QuickReturnActivity.class);
                break;
            case R.id.bt3:
                skipActivity(WandouIndexActivity.class);
                break;
            case R.id.bt4:
                skipActivity(WelActivity.class);
                break;
            case R.id.bt5:
                skipActivity(ZokeSupportMainActivity.class);
                break;
            case R.id.bt6:
                skipActivity(LoadViewHelperAty.class);
                break;
            case R.id.bt7:
                skipActivity(ShadowLayoutAty.class);
                break;
            case R.id.bt8:
                skipActivity(SwipeBackAty.class);
                break;

        }
    }
    private void skipActivity(Class<?> classOf) {
        Intent intent = new Intent(getApplicationContext(), classOf);
        startActivity(intent);
    }
}
