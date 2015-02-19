package com.zzmstring.viewset.UI.PullToRefresh;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.RefreshAndLoading.UltraPulltoRefresh.PtrDefaultHandler;
import com.zzmstring.viewset.View.RefreshAndLoading.UltraPulltoRefresh.PtrFrameLayout;
import com.zzmstring.viewset.View.RefreshAndLoading.UltraPulltoRefresh.PtrHandler;

/**
 * Created by zzmstring on 2015/2/19.
 */
public class UltraPulltoRefreshActivity extends BaseActivity{
    @ViewInject(R.id.store_house_ptr_image_content)
    LinearLayout store_house_ptr_image_content;
    @ViewInject(R.id.store_house_ptr_frame)
    PtrFrameLayout store_house_ptr_frame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_ultraptr1);
        ViewUtils.inject(this);

    }
    @Override
    public void initListener() {
        TextView textView=new TextView(this);
        textView.setText("哈哈哈哈哈哈");
        store_house_ptr_frame.setLoadingMinTime(1000);
        store_house_ptr_frame.setDurationToCloseHeader(1500);
        store_house_ptr_frame.setHeaderView(textView);
        store_house_ptr_frame.postDelayed(new Runnable() {
            @Override
            public void run() {
                store_house_ptr_frame.autoRefresh(false);
            }
        }, 100);
        // the following are default settings
        store_house_ptr_frame.setResistance(1.7f);
        store_house_ptr_frame.setRatioOfHeaderHeightToRefresh(1.2f);
        store_house_ptr_frame.setDurationToClose(200);
        store_house_ptr_frame.setDurationToCloseHeader(1000);
// default is false
        store_house_ptr_frame.setPullToRefresh(true);
// default is true
        store_house_ptr_frame.setKeepHeaderWhenRefresh(true);
        store_house_ptr_frame.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return
                        true;
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        store_house_ptr_frame.refreshComplete();
                    }
                },1800);
            }
        });
    }

    @Override
    public void initData() {

    }
}
