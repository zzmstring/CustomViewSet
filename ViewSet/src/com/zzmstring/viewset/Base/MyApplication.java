package com.zzmstring.viewset.Base;

import java.util.HashMap;
import java.util.Map;



import android.app.Application;
import android.util.Log;

import com.facebook.stetho.Stetho;
import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.config.Configuration;
import com.path.android.jobqueue.log.CustomLogger;
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
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
        configureJobManager();
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
    private JobManager jobManager;
	public static MyApplication getApp() {
		return mAppApplication;
	}

    private void configureJobManager() {
        Configuration configuration = new Configuration.Builder(this)
                .customLogger(new CustomLogger() {
                    private static final String TAG = "JOBS";
                    @Override
                    public boolean isDebugEnabled() {
                        return true;
                    }

                    @Override
                    public void d(String text, Object... args) {
                        Log.d(TAG, String.format(text, args));
                    }

                    @Override
                    public void e(Throwable t, String text, Object... args) {
                        Log.e(TAG, String.format(text, args), t);
                    }

                    @Override
                    public void e(String text, Object... args) {
                        Log.e(TAG, String.format(text, args));
                    }
                })
                .minConsumerCount(1)//always keep at least one consumer alive
                .maxConsumerCount(3)//up to 3 consumers at a time
                .loadFactor(3)//3 jobs per consumer
                .consumerKeepAlive(120)//wait 2 minute
                .build();
        jobManager = new JobManager(this, configuration);
    }

    public JobManager getJobManager() {
        return jobManager;
    }
}
