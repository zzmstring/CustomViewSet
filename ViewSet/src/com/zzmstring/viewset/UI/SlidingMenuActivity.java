package com.zzmstring.viewset.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.single.MaterialImageView;
import com.zzmstring.viewset.View.slidingmenu.SlidingMenu;

import java.io.File;

import androidx.pluginmgr.PlugInfo;
import androidx.pluginmgr.PluginManager;

/**
 * Created by zzmstring on 2015/2/26.
 */
public class SlidingMenuActivity extends BaseActivity {
    @ViewInject(R.id.iv_toggle)
    ImageView iv_toggle;
    @ViewInject(R.id.pic1)
    MaterialImageView pic1;
    @ViewInject(R.id.bt_pluginapp)
    Button bt_pluginapp;
    @ViewInject(R.id.bt_jiazai)
    Button bt_jiazai;
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
        bt_pluginapp.setOnClickListener(this);
        bt_jiazai.setOnClickListener(this);
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
            case R.id.bt_pluginapp:
                Intent intent=new Intent(this,PluginAppActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_jiazai:
                PluginManager pluginMgr = PluginManager.getInstance(this);
                File myPlug = new File("/storage/sdcard0/Download/Anroid.apk");
                PlugInfo plug = null;
                try {
                    plug = pluginMgr.loadPlugin(myPlug).iterator().next();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                pluginMgr.startMainActivity(this, plug.getPackageName());
                break;
        }
    }
}
