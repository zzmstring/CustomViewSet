package com.zzmstring.viewset.UI.other;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.Utils.ExLog;

/**
 * Created by zzmstring on 2015/5/18.
 */
public class GanjiAty2 extends BaseActivity {
    @ViewInject(R.id.bt_1)
    Button bt_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.aty_mylayout4);
        ViewUtils.inject(this);
    }

    @Override
    public void initListener() {
        bt_1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_1:
                ExLog.l("点击了bt1");
                break;


        }
    }
}
