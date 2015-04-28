package com.zzmstring.viewset.UI.every.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.Fragment.DragFragmentList.topnews.NewsFragment;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.toutiaotab.CategoryTabStrip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzmstring on 2015/4/28.
 */
public class TopNewsAty extends BaseActivity {
    private CategoryTabStrip tabs;
    private ViewPager pager;
    private MyPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topnewstabs);

        tabs = (CategoryTabStrip) findViewById(R.id.category_strip);
        pager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new MyPagerAdapter(getSupportFragmentManager());

        pager.setAdapter(adapter);

        tabs.setViewPager(pager);
    }

    @Override
    public void initView() {

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
    public class MyPagerAdapter extends FragmentPagerAdapter {

        private final List<String> catalogs = new ArrayList<String>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            catalogs.add(getString(R.string.category_hot));
            catalogs.add("\u672c\u5730");
            catalogs.add(getString(R.string.category_video));
            catalogs.add(getString(R.string.category_society));
            catalogs.add(getString(R.string.category_entertainment));
            catalogs.add(getString(R.string.category_tech));
            catalogs.add(getString(R.string.category_finance));
            catalogs.add(getString(R.string.category_military));
            catalogs.add(getString(R.string.category_world));
            catalogs.add(getString(R.string.category_image_ppmm));
            catalogs.add(getString(R.string.category_health));
            catalogs.add(getString(R.string.category_government));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return catalogs.get(position);
        }

        @Override
        public int getCount() {
            return catalogs.size();
        }

        @Override
        public Fragment getItem(int position) {
            return NewsFragment.newInstance(position);
        }

    }
}
