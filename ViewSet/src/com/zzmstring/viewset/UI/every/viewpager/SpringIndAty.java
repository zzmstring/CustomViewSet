package com.zzmstring.viewset.UI.every.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.lidroid.xutils.ViewUtils;
import com.zzmstring.viewset.Adapter.FragmentAdapter;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.Fragment.DragFragmentList.ListFragment;
import com.zzmstring.viewset.Fragment.DragFragmentList.ListFragment2;
import com.zzmstring.viewset.Fragment.DragFragmentList.ListFragment3;
import com.zzmstring.viewset.Fragment.DragFragmentList.ListFragment4;
import com.zzmstring.viewset.Fragment.DragFragmentList.ListFragment5;
import com.zzmstring.viewset.Fragment.DragFragmentList.ListFragment6;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.springindicator.SpringIndicator;
import com.zzmstring.viewset.View.springindicator.viewpager.ScrollerViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzmstring on 2015/5/2.
 */
public class SpringIndAty extends BaseActivity {
    ScrollerViewPager viewPager;
    private List<Fragment> mListFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        mListFragment=new ArrayList<Fragment>();
        ListFragment listFragment=new ListFragment();
        ListFragment2 listFragment2=new ListFragment2();
        ListFragment3 listFragment3=new ListFragment3();
        ListFragment4 listFragment4=new ListFragment4();
        ListFragment5 listFragment5=new ListFragment5();
        ListFragment6 listFragment6=new ListFragment6();
        mListFragment.add(listFragment);
        mListFragment.add(listFragment2);
        mListFragment.add(listFragment3);
        mListFragment.add(listFragment4);
        mListFragment.add(listFragment5);
        mListFragment.add(listFragment6);
        FragmentAdapter fragmentAdapter=new FragmentAdapter(getSupportFragmentManager(),mListFragment);
        setContentView(R.layout.activity_spring);
        ViewUtils.inject(this);
        viewPager = (ScrollerViewPager) findViewById(R.id.view_pager);
        SpringIndicator springIndicator = (SpringIndicator) findViewById(R.id.indicator);

        viewPager.setAdapter(fragmentAdapter);
        viewPager.fixScrollSpeed();

        // just set viewPager
        springIndicator.setViewPager(viewPager);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
