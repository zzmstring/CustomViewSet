package com.zzmstring.viewset.UI.PullToRefresh;

import android.os.Bundle;

import com.lidroid.xutils.ViewUtils;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;

/**
 * Created by zzmstring on 2015/2/20.
 */
public class DropAndDownListViewActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_dropanddownlistview);
        ViewUtils.inject(this);


    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

}
