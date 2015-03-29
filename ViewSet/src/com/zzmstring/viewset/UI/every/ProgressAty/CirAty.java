package com.zzmstring.viewset.UI.every.ProgressAty;

import android.os.Bundle;
import android.os.Handler;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.circleprogress.ArcProgress;
import com.zzmstring.viewset.View.circleprogress.CircleProgress;
import com.zzmstring.viewset.View.circleprogress.DonutProgress;

/**
 * Created by zzmstring on 2015/3/27.
 */
public class CirAty extends BaseActivity {
    @ViewInject(R.id.donut_progress)
    DonutProgress donut_progress;
    @ViewInject(R.id.circle_progress)
    CircleProgress circle_progress;
    @ViewInject(R.id.arc_progress)
    ArcProgress arc_progress;
    int progress = 0;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.aty_cir);
        ViewUtils.inject(this);


    }

    @Override
    public void initListener() {
        handler = new Handler();
        for (int i = 0; i < 50; i++) {
            final int finalI = i;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    donut_progress.setProgress(finalI *2);
                    circle_progress.setProgress(finalI *2);
                    arc_progress.setProgress(finalI *2);
                }
            },100*(i+1));
        }

    }

    @Override
    public void initData() {

    }

}
