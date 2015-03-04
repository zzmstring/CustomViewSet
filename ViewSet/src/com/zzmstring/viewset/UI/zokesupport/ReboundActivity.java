package com.zzmstring.viewset.UI.zokesupport;

import android.os.Bundle;
import android.view.View;

import com.lidroid.xutils.ViewUtils;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;

/**
 * Created by ZGL on 2015/3/4.
 */
public class ReboundActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
    setContentView(R.layout.activity_rebound);
        ViewUtils.inject(this);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {

    }
}
