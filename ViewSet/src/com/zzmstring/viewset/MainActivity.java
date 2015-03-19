package com.zzmstring.viewset;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
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
import com.zzmstring.viewset.UI.splash.WelActivity;
import com.zzmstring.viewset.UI.zokesupport.ZokeSupportMainActivity;

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
	}
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_gridview:
                Intent intent=new Intent(this, DragGridViewActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_quickreturn:
                Intent intent1=new Intent(this, QuickReturnActivity.class);
                startActivity(intent1);
                break;
            case R.id.bt_jni1:
                Intent intent2=new Intent(this, JNI1Activity.class);
                startActivity(intent2);
                break;
            case R.id.bt_tclip:
                Intent intent3=new Intent(this, TClipActivity.class);
                startActivity(intent3);
                break;
            case R.id.bt_crouton:
                Intent intent4=new Intent(this, CroutonActivity.class);
                startActivity(intent4);
                break;
            case R.id.bt_loadingprogresbar:
                Intent intent5=new Intent(this, LoadingProgressBarActivity.class);
                startActivity(intent5);
                break;
            case R.id.bt_DragTopLayout:
                Intent intent6=new Intent(this, DragTopLayoutActivity.class);
                startActivity(intent6);
                break;
            case R.id.bt_smoothprogressbar:
                Intent intent7=new Intent(this, SmoothProgressBarActivity.class);
                startActivity(intent7);
                break;
            case R.id.bt_RetalsPull:
                Intent intent8=new Intent(this, RetalsPullToRefreshActvity.class);
                startActivity(intent8);
                break;
            case R.id.bt_refresh:
                Intent intent9=new Intent(this, RefreshAndLoadActivity.class);
                startActivity(intent9);
                break;
            case R.id.bt_wandouindex:
                Intent intent10=new Intent(this, WandouIndexActivity.class);
                startActivity(intent10);
                break;
            case R.id.bt_slidemenu:
                Intent intent11=new Intent(this, SlidingMenuActivity.class);
                startActivity(intent11);
                break;
            case R.id.bt_appmsg:
                Intent intent12=new Intent(this, AppMsgActivity.class);
                startActivity(intent12);
                break;
            case R.id.bt_zoke:
                Intent intent13=new Intent(this, ZokeSupportMainActivity.class);
                startActivity(intent13);
                break;
            case R.id.bt_wel:
                Intent intent14=new Intent(this, WelActivity.class);
                startActivity(intent14);
                break;
            case R.id.bt_layout:
                break;
            case R.id.bt_progressbar:
                break;
            case R.id.bt_dialog:
                break;
            case R.id.bt_listview:
                break;
            case R.id.bt_materialD:
                break;
            case R.id.bt_fresh:
                break;
            case R.id.bt_drawer:
                break;
            case R.id.iv_image:
                break;
        }
    }
	
}
