package com.zzmstring.viewset.Base;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import android.view.View;


public  class BaseActivity extends FragmentActivity implements View.OnClickListener{


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
		initListener();
		initData();
	}
	
	public  void initView(){

    }

	public  void initListener(){

    }

	public  void initData(){

    }


    @Override
    protected void onResume() {

        super.onResume();
    }

    @Override
    protected void onPause() {

        super.onPause();
    }







    @Override
    public void onClick(View v) {

    }



}
