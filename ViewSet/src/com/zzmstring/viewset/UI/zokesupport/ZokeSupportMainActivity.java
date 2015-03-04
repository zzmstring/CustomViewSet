package com.zzmstring.viewset.UI.zokesupport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.ZokeSupportv1.view.FlippingLoadingDialog;
import com.zzmstring.viewset.View.ZokeSupportv1.view.ZokeToast;

/**
 * Created by ZGL on 2015/3/4.
 */
public class ZokeSupportMainActivity extends BaseActivity{
    FlippingLoadingDialog dialog;
    @ViewInject(R.id.toast)
    Button toast;
    @ViewInject(R.id.rebound)
    Button rebound;
    @ViewInject(R.id.loaddia)
    Button loaddia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_zokemain);
        ViewUtils.inject(this);
        dialog=new FlippingLoadingDialog(this,"这就是个对话框");
        dialog.setCancelable(true);
    }

    @Override
    public void initListener() {
        toast.setOnClickListener(this);
        rebound.setOnClickListener(this);
        loaddia.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.toast:
                ZokeToast.show(this,"哈哈哈",R.drawable.buildings);
                break;
            case R.id.rebound:
                intent=new Intent(this,ReboundActivity.class);
                startActivity(intent);
                break;
            case R.id.loaddia:

                dialog.show();
                break;
        }

    }
}
