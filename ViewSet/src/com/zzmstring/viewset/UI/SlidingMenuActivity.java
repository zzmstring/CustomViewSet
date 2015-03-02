package com.zzmstring.viewset.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.single.MaterialImageView;
import com.zzmstring.viewset.View.slidingmenu.SlidingMenu;

/**
 * Created by zzmstring on 2015/2/26.
 */
public class SlidingMenuActivity extends BaseActivity {
    @ViewInject(R.id.iv_toggle)
    ImageView iv_toggle;
    @ViewInject(R.id.pic1)
    MaterialImageView pic1;
    SlidingMenu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void initView() {
        setContentView(R.layout.activity_slidingmenu);
        ViewUtils.inject(this);
    }

    @Override
    public void initListener() {
        iv_toggle.setOnClickListener(this);
        pic1.setRotation(-10);

    }
    @Override
    public void initData() {
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.slidemenu1);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_toggle:
                    menu.toggle();
                break;
        }
    }
}
