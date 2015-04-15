package com.zzmstring.viewset.UI.every.LayoutAty;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.zzmstring.viewset.Adapter.TestAdapter;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.swipeback.SwipeBackLayout;

/**
 * Created by zzmstring on 2015/4/15.
 */
public class SwipeBackAty extends BaseActivity {
    private ListView lv;
    private TestAdapter adapter;
    private SwipeBackLayout swipeBackLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void initView() {
        setContentView(R.layout.aty_swipeback);
    }
    @Override
    public void initListener() {
    }
    @Override
    public void initData() {
        swipeBackLayout = (SwipeBackLayout) findViewById(R.id.swipeBackLayout);
        swipeBackLayout.setDragEdge(SwipeBackLayout.DragEdge.TOP);
        adapter=new TestAdapter(this);
        lv = (ListView) this.findViewById(R.id.listview);
        lv.setAdapter(adapter);
    }
}
