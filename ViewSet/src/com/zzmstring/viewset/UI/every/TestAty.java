package com.zzmstring.viewset.UI.every;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.path.android.jobqueue.JobManager;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.Base.MyApplication;
import com.zzmstring.viewset.Bean.TestJob;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.UI.other.GanjiAty;
import com.zzmstring.viewset.UI.other.GanjiAty2;

import org.simple.eventbus.EventBus;

/**
 * Created by zzmstring on 2015/4/18.
 */
public class TestAty extends BaseActivity {
    @ViewInject(R.id.bt1)
    Button bt1;
    @ViewInject(R.id.bt2)
    Button bt2;
    @ViewInject(R.id.bt3)
    Button bt3;
    @ViewInject(R.id.bt4)
    Button bt4;
    @ViewInject(R.id.bt5)
    Button bt5;
    @ViewInject(R.id.bt6)
    Button bt6;
    @ViewInject(R.id.bt7)
    Button bt7;
    @ViewInject(R.id.bt8)
    Button bt8;
    @ViewInject(R.id.bt9)
    Button bt9;
    @ViewInject(R.id.bt10)
    Button bt10;
    @ViewInject(R.id.bt11)
    Button bt11;
    @ViewInject(R.id.bt12)
    Button bt12;
    @ViewInject(R.id.bt13)
    Button bt13;
    @ViewInject(R.id.bt14)
    Button bt14;
    @ViewInject(R.id.bt15)
    Button bt15;
    @ViewInject(R.id.bt16)
    Button bt16;
    @ViewInject(R.id.bt17)
    Button bt17;
    @ViewInject(R.id.bt18)
    Button bt18;
    @ViewInject(R.id.bt19)
    Button bt19;
    @ViewInject(R.id.bt20)
    Button bt20;
    @ViewInject(R.id.bt21)
    Button bt21;
    @ViewInject(R.id.bt22)
    Button bt22;
    @ViewInject(R.id.bt23)
    Button bt23;
    @ViewInject(R.id.bt24)
    Button bt24;
    JobManager jobManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_every);
        ViewUtils.inject(this);
        jobManager = MyApplication.getApp().getJobManager();
    }

    @Override
    public void initData() {
        bt1.setText("andevent");
        bt2.setText("job");
        bt3.setText("ganji");
        bt4.setText("ganji2");
    }

    @Override
    public void initListener() {
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                test1();
                break;
            case R.id.bt2:
                test2();
                break;
            case R.id.bt3:
                skip(GanjiAty.class);
                break;
            case R.id.bt4:
                skip(GanjiAty2.class);
                break;
            
        }
    }

    private void test1() {
        EventBus.getDefault().post("zzm.string", "my_tag");
    }

    private void test2() {
        jobManager.addJobInBackground(new TestJob("test"));
    }
}
