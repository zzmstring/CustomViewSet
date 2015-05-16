package com.zzmstring.viewset.UI.every;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.my.CircleImageDrawable;
import com.zzmstring.viewset.View.my.RoundImageDrawable;

/**
 * Created by zzmstring on 2015/5/14.
 */
public class DrawableAty extends BaseActivity{
    @ViewInject(R.id.iv_1)
    ImageView iv_1;
    @ViewInject(R.id.iv_2)
    ImageView iv_2;
    @ViewInject(R.id.iv_3)
    ImageView iv_3;
    @ViewInject(R.id.iv_4)
    ImageView iv_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.aty_drawable);
        ViewUtils.inject(this);
    }

    @Override
    public void initData() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.mv1);

        iv_1.setImageDrawable(new RoundImageDrawable(bitmap));
        iv_2.setImageDrawable(new CircleImageDrawable(bitmap));
    }

    @Override
    public void initListener() {

    }

}
