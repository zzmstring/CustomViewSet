package com.zzmstring.viewset.UI;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;


import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.Adapter.TestAdapter;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.Utils.ParamsUtil;
import com.zzmstring.viewset.View.quickreturn.library.enums.QuickReturnType;
import com.zzmstring.viewset.View.quickreturn.library.listeners.QuickReturnListViewOnScrollListener;

/**
 * Created by zzmx on 2015/1/27.
 */
public class QuickReturnActivity extends Activity{
    @ViewInject(R.id.tv_test)
    TextView tv_test;
    @ViewInject(R.id.lv_main)
    ListView lv_main;
    public TestAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quickreturn);
        ViewUtils.inject(this);
        mAdapter=new TestAdapter(this);
        lv_main.setAdapter(mAdapter);
        // Set up the QuickReturn scroll listener
        int headerHeight= ParamsUtil.dip2px(this, 200);
        QuickReturnListViewOnScrollListener scrollListener = new QuickReturnListViewOnScrollListener(QuickReturnType.HEADER,
                tv_test, -headerHeight, null, 0);
        // Setting to true will slide the header and/or footer into view or slide out of view based
        // on what is visible in the idle scroll state
        scrollListener.setCanSlideInIdleScrollState(true);
        lv_main.setOnScrollListener(scrollListener);
    }
}
