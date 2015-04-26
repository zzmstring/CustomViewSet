package com.zzmstring.viewset;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.percolate.caffeine.DialogUtils;
import com.zzmstring.viewset.UI.AppMsgActivity;
import com.zzmstring.viewset.UI.CroutonActivity;
import com.zzmstring.viewset.UI.DragGridViewActivity;
import com.zzmstring.viewset.UI.DragTopLayoutActivity;
import com.zzmstring.viewset.UI.JNI1Activity;
import com.zzmstring.viewset.UI.LoadingProgressBarActivity;
import com.zzmstring.viewset.UI.QuickReturnActivity;
import com.zzmstring.viewset.UI.RefreshAndLoadActivity;
import com.zzmstring.viewset.UI.RetalsPullToRefreshActvity;
import com.zzmstring.viewset.UI.SlidingMenuActivity;
import com.zzmstring.viewset.UI.SmoothProgressBarActivity;
import com.zzmstring.viewset.UI.TClipActivity;
import com.zzmstring.viewset.UI.WandouIndexActivity;
import com.zzmstring.viewset.UI.every.EImageAty;
import com.zzmstring.viewset.UI.every.EMdAty;
import com.zzmstring.viewset.UI.every.EVewPagerAty;
import com.zzmstring.viewset.UI.every.EdialogAty;
import com.zzmstring.viewset.UI.every.EdrawerAty;
import com.zzmstring.viewset.UI.every.ElayoutAty;
import com.zzmstring.viewset.UI.every.ElistViewAty;
import com.zzmstring.viewset.UI.every.EprogressAty;
import com.zzmstring.viewset.UI.every.ErefreshAty;
import com.zzmstring.viewset.UI.every.TestAty;
import com.zzmstring.viewset.UI.other.AnimationsAty;
import com.zzmstring.viewset.UI.splash.WelActivity;
import com.zzmstring.viewset.UI.zokesupport.ZokeSupportMainActivity;
import com.zzmstring.viewset.Utils.orhan.LogLevel;
import com.zzmstring.viewset.Utils.orhan.Logger;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;


public class MainActivity extends Activity implements View.OnClickListener {
    @ViewInject(R.id.bt_gridview)
    Button bt_gridview;
    @ViewInject(R.id.bt_quickreturn)
    Button bt_quickreturn;
    @ViewInject(R.id.bt_jni1)
    Button bt_jni1;
    @ViewInject(R.id.bt_tclip)
    Button bt_tclip;
    @ViewInject(R.id.bt_crouton)
    Button bt_crouton;
    @ViewInject(R.id.bt_loadingprogresbar)
    Button bt_loadingprogresbar;
    @ViewInject(R.id.bt_DragTopLayout)
    Button bt_DragTopLayout;
    @ViewInject(R.id.bt_smoothprogressbar)
    Button bt_smoothprogressbar;
    @ViewInject(R.id.bt_RetalsPull)
    Button bt_RetalsPull;
    @ViewInject(R.id.bt_refresh)
    Button bt_refresh;
    @ViewInject(R.id.bt_wandouindex)
    Button bt_wandouindex;
    @ViewInject(R.id.bt_slidemenu)
    Button bt_slidemenu;
    @ViewInject(R.id.bt_appmsg)
    Button bt_appmsg;
    @ViewInject(R.id.bt_zoke)
    Button bt_zoke;
    @ViewInject(R.id.bt_wel)
    Button bt_wel;
    @ViewInject(R.id.bt_layout)
    Button bt_layout;
    @ViewInject(R.id.bt_progressbar)
    Button bt_progressbar;
    @ViewInject(R.id.bt_dialog)
    Button bt_dialog;
    @ViewInject(R.id.bt_listview)
    Button bt_listview;
    @ViewInject(R.id.bt_materialD)
    Button bt_materialD;
    @ViewInject(R.id.bt_fresh)
    Button bt_fresh;
    @ViewInject(R.id.bt_drawer)
    Button bt_drawer;
    @ViewInject(R.id.iv_image)
    Button iv_image;
    @ViewInject(R.id.bt_test)
    Button bt_test;
    private static final String TAG = MainActivity.class.getSimpleName();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
        ViewUtils.inject(this);
        bt_gridview.setOnClickListener(this);
        bt_quickreturn.setOnClickListener(this);
        bt_jni1.setOnClickListener(this);
        bt_tclip.setOnClickListener(this);
        bt_crouton.setOnClickListener(this);
        bt_loadingprogresbar.setOnClickListener(this);
        bt_DragTopLayout.setOnClickListener(this);
        bt_smoothprogressbar.setOnClickListener(this);
        bt_RetalsPull.setOnClickListener(this);
        bt_refresh.setOnClickListener(this);
        bt_wandouindex.setOnClickListener(this);
        bt_slidemenu.setOnClickListener(this);
        bt_appmsg.setOnClickListener(this);
        bt_zoke.setOnClickListener(this);
        bt_wel.setOnClickListener(this);
        bt_layout.setOnClickListener(this);
        bt_progressbar.setOnClickListener(this);
        bt_dialog.setOnClickListener(this);
        bt_listview.setOnClickListener(this);
        bt_materialD.setOnClickListener(this);
        bt_fresh.setOnClickListener(this);
        bt_drawer.setOnClickListener(this);
        iv_image.setOnClickListener(this);
        bt_test.setOnClickListener(this);
        EventBus.getDefault().register(this);

	}
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_quickreturn:
                skipActivity(EVewPagerAty.class);
                break;
            case R.id.bt_gridview:
                skipActivity(DragGridViewActivity.class);
                break;

            case R.id.bt_jni1:
                skipActivity(JNI1Activity.class);
                break;
            case R.id.bt_tclip:
                skipActivity(TClipActivity.class);
                break;
            case R.id.bt_crouton:
                skipActivity(CroutonActivity.class);
                break;


            case R.id.bt_RetalsPull:

            case R.id.bt_refresh:
                skipActivity(AnimationsAty.class);
                break;

            case R.id.bt_slidemenu:
                skipActivity(SlidingMenuActivity.class);
                break;
            case R.id.bt_appmsg:

                break;
            case R.id.bt_zoke:

                break;
            case R.id.bt_wel:

                break;
            case R.id.bt_layout:
                skipActivity(ElayoutAty.class);
                break;
            case R.id.bt_progressbar:
                skipActivity(EprogressAty.class);
                break;
            case R.id.bt_dialog:
                skipActivity(EdialogAty.class);
                break;
            case R.id.bt_listview:
                skipActivity(ElistViewAty.class);
                break;
            case R.id.bt_materialD:
                skipActivity(EMdAty.class);
                break;
            case R.id.bt_fresh:
                skipActivity(ErefreshAty.class);
                break;
            case R.id.bt_drawer:
                skipActivity(EdrawerAty.class);
                break;
            case R.id.iv_image:
                skipActivity(EImageAty.class);
                break;
            case R.id.bt_test:
                skipActivity(TestAty.class);
                break;
        }
    }
    private void skipActivity(Class<?> classOf) {
        Intent intent = new Intent(getApplicationContext(), classOf);
        startActivity(intent);
    }

    private void test(){
        Logger.v("test2", 3);
        Logger.v("test3", 0);
        Logger.v("MYTAG", "test3", 2);
        Logger.wtf("test3", 1);
        Logger.d(TAG, "logger with tag");
        Logger.d("tag3", "logger with tag");
        Logger.d("ta", "logger with tag");

    }
    private void test2(){
        DialogUtils.quickDialog(this, "Some awesome message");
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
    @Subscriber(tag = "my_tag")
    private void updateUserWithTag(String user) {
        Logger.v("", "### update username with my_tag, name = " + user);
    }
}
