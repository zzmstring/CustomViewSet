package com.zzmstring.viewset.UI.every;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.UI.RefreshAndLoadActivity;
import com.zzmstring.viewset.UI.RetalsPullToRefreshActvity;


/**
 * Created by zzmstring on 2015/3/19.
 */
public class ErefreshAty extends BaseActivity {
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
        bt1.setText("Retals");
        bt2.setText("ReAndLo");
        bt3.setText("iosrefresh");

    }

    @Override
    public void initListener() {
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:
                skipActivity(RetalsPullToRefreshActvity.class);
                break;
            case R.id.bt2:
                skipActivity(RefreshAndLoadActivity.class);
                break;
            case R.id.bt3:

                break;
        }
    }
    private Intent intent;
    private void skipActivity(Class<?> classOf) {
        intent = new Intent(getApplicationContext(), classOf);
        startActivity(intent);
    }
}
