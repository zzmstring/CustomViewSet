package com.zzmstring.viewset.UI;

import android.os.Bundle;
import android.view.View;

import com.lidroid.xutils.ViewUtils;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;

/**
 * Created by zzmstring on 2015/2/16.
 */
public class RefreshAndLoadActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_refreshandload);
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
        switch (v.getId()){

        }
    }
}
