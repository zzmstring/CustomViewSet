package com.zzmstring.viewset.UI.every;

import android.os.Bundle;
import android.view.View;

import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;

import butterknife.ButterKnife;

/**
 * Created by zzmstring on 2015/3/19.
 */
public class EMdAty extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_every);
        ButterKnife.inject(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
