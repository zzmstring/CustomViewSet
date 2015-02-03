package com.zzmstring.viewset;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.UI.DragGridViewActivity;
import com.zzmstring.viewset.UI.JNI1Activity;
import com.zzmstring.viewset.UI.QuickReturnActivity;
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
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        ViewUtils.inject(this);
        bt_gridview.setOnClickListener(this);
        bt_quickreturn.setOnClickListener(this);
        bt_jni1.setOnClickListener(this);
        bt_tclip.setOnClickListener(this);
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
        }




    }
	
}
