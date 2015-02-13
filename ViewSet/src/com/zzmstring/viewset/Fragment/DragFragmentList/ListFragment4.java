package com.zzmstring.viewset.Fragment.DragFragmentList;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.Adapter.TestAdapter;
import com.zzmstring.viewset.Base.BaseFragment;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.DragTopLayout.AttachUtil;

import de.greenrobot.event.EventBus;

/**
 * Created by zzmstring on 2015/2/13.
 */
public class ListFragment4 extends BaseFragment{
    @ViewInject(R.id.lv_main)
    ListView lv_main;
    TestAdapter mAdapter;
    @Override
    public View initView(LayoutInflater inflater) {
        View view =inflater.inflate(R.layout.fragment_draglayoutlist,null);
        ViewUtils.inject(this,view);
        return view;

    }

    @Override
    public void initListener() {
        mAdapter=new TestAdapter(getActivity());
        lv_main.setAdapter(mAdapter);
        lv_main.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                                 int totalItemCount) {
                EventBus.getDefault().post(AttachUtil.isAdapterViewAttach(view));
            }
        });


    }

    @Override
    public void initData() {

    }
}
