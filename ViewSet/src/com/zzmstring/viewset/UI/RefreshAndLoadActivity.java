package com.zzmstring.viewset.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.UI.PullToRefresh.DropAndDownListViewActivity;
import com.zzmstring.viewset.UI.PullToRefresh.UltraPulltoRefreshActivity;

/**
 * Created by zzmstring on 2015/2/16.
 */
public class RefreshAndLoadActivity extends BaseActivity {
    @ViewInject(R.id.bt_UltraPulltoRefresh)
    Button bt_UltraPulltoRefresh;
    @ViewInject(R.id.bt_loadmore)
    Button bt_loadmore;
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
        bt_UltraPulltoRefresh.setOnClickListener(this);
        bt_loadmore.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_UltraPulltoRefresh:
                Intent intent=new Intent(this, UltraPulltoRefreshActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_loadmore:
                Intent intent1=new Intent(this, DropAndDownListViewActivity.class);
                startActivity(intent1);
                break;

        }
    }
}
