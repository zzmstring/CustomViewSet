package com.zzmstring.viewset.UI.PullToRefresh;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;

import java.util.ArrayList;

/**
 * Created by zzmstring on 2015/4/13.
 */
public class IosPullToRefreshAty extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private ListView list;
    @Override
    public void initView() {
        setContentView(R.layout.aty_iospulltorefresh);

        list = (ListView) findViewById(R.id.list);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("your group");
        arrayList.add("my group");
        arrayList.add("his group");
        arrayList.add("her group");
        arrayList.add("your group");
        arrayList.add("my group");
        arrayList.add("his group");
        arrayList.add("her group");
        arrayList.add("your group");
        arrayList.add("my group");
        arrayList.add("his group");
        arrayList.add("her group");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(adapter);

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

}
