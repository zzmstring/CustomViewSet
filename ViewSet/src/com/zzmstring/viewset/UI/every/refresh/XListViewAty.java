package com.zzmstring.viewset.UI.every.refresh;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.Adapter.TestAdapter;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.XListView.XListView;


import java.util.logging.LogRecord;

/**
 * Created by zzmstring on 2015/6/16.
 */
public class XListViewAty extends BaseActivity implements XListView.IXListViewListener {
    @ViewInject(R.id.lv_list)
    XListView lv_list;
    TestAdapter mAdapter;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.aty_xlistview);
        ViewUtils.inject(this);
        lv_list.setXListViewListener(this);
        lv_list.setPullLoadEnable(true);
        lv_list.setPullRefreshEnable(true);
        mAdapter=new TestAdapter(this);
        lv_list.setAdapter(mAdapter);
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

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                lv_list.stopRefresh();
                lv_list.stopLoadMore();
            }
        },600);
    }

    @Override
    public void onLoadMore() {

    }
}
