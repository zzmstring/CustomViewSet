package com.zzmstring.viewset.UI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

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
import com.zzmstring.viewset.View.DragTopLayout.DragTopLayout;
import com.zzmstring.viewset.View.PagerSlidingTabStrip.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by zzmstring on 2015/2/13.
 */
public class DragTopLayoutActivity extends BaseActivity{
    public static final String TAG = "MainActivity";
    private DragTopLayout dragLayout;
    private FragmentAdapter mAdapter;
    private ViewPager viewPager;
    private PagerSlidingTabStrip pagerSlidingTabStrip;
    private ImageView topImageView;
    private List<Fragment> mListFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void initView() {
        setContentView(R.layout.activity_dragtoplayout);
        mListFragment=new ArrayList<Fragment>();
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dragLayout = (DragTopLayout) findViewById(R.id.drag_layout);
        topImageView = (ImageView) findViewById(R.id.image_view);
        pagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
    }

    @Override
    public void initListener() {

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
        viewPager.setAdapter(fragmentAdapter);
        pagerSlidingTabStrip.setViewPager(viewPager);
    }
    // Handle scroll event from fragments
    public void onEvent(Boolean b){
        dragLayout.setTouchMode(b);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {

    }

}
