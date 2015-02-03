package com.zzmstring.viewset.UI;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.opencv.TClip;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.Utils.ExLog;

/**
 * Created by zzmx on 2015/2/3.
 */
public class TClipActivity extends BaseActivity {
    @ViewInject(R.id.iv_main)
    ImageView iv_main;
    @ViewInject(R.id.iv_second)
    ImageView iv_second;
    Bitmap bm;
    Bitmap tempbm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_tclip);
        ViewUtils.inject(this);
        bm= BitmapFactory.decodeResource(getResources(),R.drawable.xidada);
        String configPath = TClip.copyConfig(this, TClip.CONFIG, R.raw.haarcascade_frontalface_alt);
        tempbm=TClip.crop(configPath, bm, 10, 10);
    }

    @Override
    public void initListener() {
        ExLog.l("act>>>>"+ExLog.getCurrentMethodName());
        iv_second.setImageBitmap(tempbm);

    }

    @Override
    public void initData() {

    }

}
