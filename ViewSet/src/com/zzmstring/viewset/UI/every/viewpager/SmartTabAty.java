package com.zzmstring.viewset.UI.every.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.Adapter.FragmentAdapter;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.Fragment.DragFragmentList.ListFragment;
import com.zzmstring.viewset.Fragment.DragFragmentList.ListFragment2;
import com.zzmstring.viewset.Fragment.DragFragmentList.ListFragment3;
import com.zzmstring.viewset.Fragment.DragFragmentList.ListFragment4;
import com.zzmstring.viewset.Fragment.DragFragmentList.ListFragment5;
import com.zzmstring.viewset.Fragment.DragFragmentList.ListFragment6;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzmstring on 2015/4/26.
 */
public class SmartTabAty extends BaseActivity{
    @ViewInject(R.id.viewpagertab)
    SmartTabLayout viewpagertab;
    @ViewInject(R.id.viewpager)
    ViewPager viewpager;
    private List<Fragment> mListFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.aty_smartlayout);
        ViewUtils.inject(this);
        mListFragment=new ArrayList<Fragment>();
    }

    @Override
    public void initData() {
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
        viewpager.setAdapter(fragmentAdapter);
        viewpagertab.setViewPager(viewpager);
    }

    @Override
    public void initListener() {

    }

}
