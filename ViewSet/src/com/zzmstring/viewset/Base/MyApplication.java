package com.zzmstring.viewset.Base;

import java.util.HashMap;
import java.util.Map;



import android.app.Application;

import com.zzmstring.viewset.DB.Channel.SQLHelper;


/**
 * 存放全局变量
 * 
 * @author TopSage
 *
 */

public class MyApplication extends Application {
	public static int typeid;
	private static MyApplication mAppApplication;
	private SQLHelper sqlHelper;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mAppApplication = this;
	}
	/** 获取数据库Helper */
	public SQLHelper getSQLHelper() {
		if (sqlHelper == null)
			sqlHelper = new SQLHelper(mAppApplication);
		return sqlHelper;
	}
	
	//保存加密视频的端口号
	private int drmServerPort;
	
	private Map<String, Object> map = new HashMap<String, Object>();

	public int getDrmServerPort() {
		return drmServerPort;
	}

	public void setDrmServerPort(int drmServerPort) {
		this.drmServerPort = drmServerPort;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	public void put(String key, Object object) {
	
		map.put(key, object);
	
	}

	public Object get(String key) {

		return map.get(key);

	}
	public static MyApplication getApp() {
		return mAppApplication;
	}
}
