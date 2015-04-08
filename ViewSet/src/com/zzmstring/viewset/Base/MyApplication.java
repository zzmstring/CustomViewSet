package com.zzmstring.viewset.Base;

import java.util.HashMap;
import java.util.Map;



import android.app.Application;

import com.zzmstring.viewset.DB.Channel.SQLHelper;
import com.zzmstring.viewset.Utils.orhan.LogLevel;
import com.zzmstring.viewset.Utils.orhan.Logger;


/**
 * 存放全局变量
 * 
 *
 *
 */

public class MyApplication extends Application {

	private static MyApplication mAppApplication;
	private SQLHelper sqlHelper;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mAppApplication = this;
        Logger.init()
                .setMethodCount(1)
                .setLogLevel(LogLevel.FULL);
	}
	/** 获取数据库Helper */
	public SQLHelper getSQLHelper() {
		if (sqlHelper == null)
			sqlHelper = new SQLHelper(mAppApplication);
		return sqlHelper;
	}
	

	
	private Map<String, Object> map = new HashMap<String, Object>();



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
