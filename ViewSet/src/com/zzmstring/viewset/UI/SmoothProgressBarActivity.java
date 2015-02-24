package com.zzmstring.viewset.UI;

import android.os.Bundle;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.SmoothProgressBar.SmoothProgressBar;
import com.zzmstring.viewset.View.SmoothProgressBar.SmoothProgressBarUtils;
import com.zzmstring.viewset.View.SmoothProgressBar.SmoothProgressDrawable;

/**
 * Created by zzmstring on 2015/2/14.
 */
public class SmoothProgressBarActivity extends BaseActivity {
    @ViewInject(R.id.google_now)
    SmoothProgressBar google_now;
    @ViewInject(R.id.gradient)
    SmoothProgressBar gradient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_smothprogressbar);
        ViewUtils.inject(this);

    }

    @Override
    public void initListener() {
        gradient.progressiveStart();

        google_now.setSmoothProgressDrawableBackgroundDrawable(
                SmoothProgressBarUtils.generateDrawableWithColors(
                        getResources().getIntArray(R.array.pocket_background_colors),
                        ((SmoothProgressDrawable) google_now.getIndeterminateDrawable()).getStrokeWidth()));
        google_now.progressiveStart();

    }

    @Override
    public void initData() {

    }

}
