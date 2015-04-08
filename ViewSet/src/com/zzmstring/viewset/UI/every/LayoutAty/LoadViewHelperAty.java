package com.zzmstring.viewset.UI.every.LayoutAty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;

/**
 * Created by zzmstring on 2015/4/8.
 */
public class LoadViewHelperAty extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void initView() {
        setContentView(R.layout.activity_loadviewhelper);
    }
    @Override
    public void initListener() {
    }
    @Override
    public void initData() {
    }
    public void showSimple(View view) {
        startActivity(new Intent(getApplicationContext(), SimpleActivity.class));
    }
    public void showExample1(View view) {
        startActivity(new Intent(getApplicationContext(), Example1Activity.class));
    }
    public void showExample2(View view) {
        startActivity(new Intent(getApplicationContext(), Example2Activity.class));
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
}
