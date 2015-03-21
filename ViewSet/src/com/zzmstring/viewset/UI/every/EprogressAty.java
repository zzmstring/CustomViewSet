package com.zzmstring.viewset.UI.every;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.UI.every.ProgressAty.ProgressMainAty;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by zzmstring on 2015/3/19.
 */
public class EprogressAty extends BaseActivity {
    @ViewInject(R.id.bt1p)
    Button bt1p;
    @ViewInject(R.id.bt2p)
    Button bt2p;
    @ViewInject(R.id.bt3p)
    Button bt3p;
    @ViewInject(R.id.bt4p)
    Button bt4p;
    @ViewInject(R.id.bt5p)
    Button bt5p;
    @ViewInject(R.id.bt6p)
    Button bt6p;
    @ViewInject(R.id.bt7p)
    Button bt7p;
    @ViewInject(R.id.bt8p)
    Button bt8p;
    @ViewInject(R.id.bt9p)
    Button bt9p;
    @ViewInject(R.id.bt10p)
    Button bt10p;
//    @ViewInject(R.id.bt11p)
//    Button bt11p;
//    @ViewInject(R.id.bt12p)
//    Button bt12p;
//    @ViewInject(R.id.bt13p)
//    Button bt13p;
//    @ViewInject(R.id.bt14p)
//    Button bt14p;
//    @ViewInject(R.id.bt15p)
//    Button bt15p;
//    @ViewInject(R.id.bt16p)
//    Button bt16p;
//    @ViewInject(R.id.bt17p)
//    Button bt17p;
//    @ViewInject(R.id.bt18p)
//    Button bt18p;
//    @ViewInject(R.id.bt19p)
//    Button bt19p;
//    @ViewInject(R.id.bt20p)
//    Button bt20p;
//    @ViewInject(R.id.bt21p)
//    Button bt21p;
//    @ViewInject(R.id.bt22p)
//    Button bt22p;
//    @ViewInject(R.id.bt23p)
//    Button bt23p;
//    @ViewInject(R.id.bt24p)
//    Button bt24p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_every_progress);
        ViewUtils.inject(this);
//        Button button= (Button) findViewById(R.id.bt1);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(EprogressAty.this, ProgressMainAty.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public void initView() {


    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        bt1p.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1p:
                Intent intent=new Intent(this, ProgressMainAty.class);
                startActivity(intent);
                break;
        }


    }
}
