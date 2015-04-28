package com.zzmstring.viewset.UI.every.refresh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.MainActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.RefreshAndLoading.pullrefresh.base.impl.PullRefreshListView;

/**
 * Created by zzmstring on 2015/4/27.
 */
public class ArefreshAty extends BaseActivity {
    ListView mListView;

    PullRefreshListView mPullRefreshListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.pull_refresh_main);
    }

    @Override
    public void initData() {
        findViewById(R.id.refresh_listview).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArefreshAty.this, ShowActivity.class);
                intent.putExtra("index", ShowActivity.REFRESH_LV);
                startActivity(intent);
            }
        });

        findViewById(R.id.refresh_gridview).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArefreshAty.this, ShowActivity.class);
                intent.putExtra("index", ShowActivity.REFRESH_GV);
                startActivity(intent);
            }
        });

        findViewById(R.id.refresh_textview).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArefreshAty.this, ShowActivity.class);
                intent.putExtra("index", ShowActivity.REFRESH_TV);
                startActivity(intent);
            }
        });

        findViewById(R.id.refresh_slide_lv).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArefreshAty.this, ShowActivity.class);
                intent.putExtra("index", ShowActivity.REFRESH_SLIDE_LV);
                startActivity(intent);
            }
        });

        // swipe layout
        findViewById(R.id.swipe_refresh_lv).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArefreshAty.this, ShowActivity.class);
                intent.putExtra("index", ShowActivity.SWIPE_LV);
                startActivity(intent);
            }
        });


    }

    @Override
    public void initListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
