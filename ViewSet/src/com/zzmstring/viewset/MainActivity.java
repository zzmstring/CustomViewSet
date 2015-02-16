package com.zzmstring.viewset;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.UI.CroutonActivity;
import com.zzmstring.viewset.UI.DragGridViewActivity;
import com.zzmstring.viewset.UI.DragTopLayoutActivity;
import com.zzmstring.viewset.UI.JNI1Activity;
import com.zzmstring.viewset.UI.LoadingProgressBarActivity;
import com.zzmstring.viewset.UI.QuickReturnActivity;
import com.zzmstring.viewset.UI.RefreshAndLoadActivity;
import com.zzmstring.viewset.UI.RetalsPullToRefreshActvity;
import com.zzmstring.viewset.UI.SmoothProgressBarActivity;
import com.zzmstring.viewset.UI.TClipActivity;


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
        }




    }
	
}
