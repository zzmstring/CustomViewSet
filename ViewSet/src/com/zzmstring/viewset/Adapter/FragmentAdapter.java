package com.zzmstring.viewset.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {
	private List<Fragment> list;
	public FragmentAdapter(FragmentManager fm, List<Fragment> list) {
		super(fm);
		this.list=list;
	}
	@Override
	public Fragment getItem(int arg0) {
		return list.get(arg0);
	}

	@Override
	public int getCount() {
		return list.size();
	}

	public String getPageTitle(int i){
        return "这就是一个临时的text";
    }
	
}
