package com.zzmstring.viewset.UI;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.LoadingProgressBar.CircleProgressBar;

/**
 * Created by zzmstring on 2015/2/12.
 */
public class LoadingProgressBarActivity extends BaseActivity {
    int progress = 0;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_loadingprogressbar);
        final CircleProgressBar progress2 = (CircleProgressBar) findViewById(R.id.progress2);

        handler = new Handler();
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    progress2.setProgress(finalI *10);
                }
            },1000*(i+1));
        }


    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {

    }
}
