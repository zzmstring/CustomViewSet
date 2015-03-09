package com.zzmstring.viewset.UI;

import android.os.Bundle;
import android.widget.Button;

import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by zzmstring on 2015/2/5.
 */
public class TestActivity extends BaseActivity {
    @InjectView(R.id.bt_haha)
    Button btHaha;
    @InjectView(R.id.bt_haha2)
    Button btHaha2;
    @InjectView(R.id.bt_haha3)
    Button btHaha3;
    @InjectView(R.id.bt_haha4)
    Button btHaha4;
    @InjectView(R.id.bt_haha5)
    Button btHaha5;
    @InjectView(R.id.bt_haha6)
    Button btHaha6;
    @InjectView(R.id.bt_haha7)
    Button btHaha7;
    @InjectView(R.id.bt_haha8)
    Button btHaha8;
    @InjectView(R.id.bt_haha9)
    Button btHaha9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_test);
        ButterKnife.inject(this);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

}
