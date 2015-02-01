package com.zzmstring.viewset.UI;

import java.util.ArrayList;



import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.zzmstring.viewset.Adapter.DragAdapter;
import com.zzmstring.viewset.Base.MyApplication;
import com.zzmstring.viewset.Bean.ChannelItem;
import com.zzmstring.viewset.DB.Channel.ChannelManage;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.DragGrid;

public class DragGridViewActivity extends Activity {
	ArrayList<ChannelItem> userChannelList = new ArrayList<ChannelItem>();
	private DragGrid dg;
	private DragAdapter dadpter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.draggridviewtest);
		dg = (DragGrid) findViewById(R.id.vgv);
		init();
		setListener();
	}
	private void init(){
		userChannelList=((ArrayList<ChannelItem>) ChannelManage.getManage(MyApplication.getApp().getSQLHelper()).getUserChannel());
		dadpter=new DragAdapter(this, userChannelList);
		dg.setAdapter(dadpter);
	}
	private void setListener(){
		dg.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getApplicationContext(), userChannelList.get(position).getName(), 0).show();
				saveChannel();
			}
		});
	}
	private void exchange(){
		saveChannel();
		
	}
	private void saveChannel() {
		ChannelManage.getManage(MyApplication.getApp().getSQLHelper()).deleteAllChannel();
		ChannelManage.getManage(MyApplication.getApp().getSQLHelper()).saveUserChannel(dadpter.getChannnelLst());
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		saveChannel();
	}
}
