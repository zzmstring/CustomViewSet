package com.zzmstring.viewset.Utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.*;
import android.os.Process;
import android.widget.Toast;

import com.google.dexmaker.dx.rop.cst.Constant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZGL on 2015/3/3.
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler mExceptionHandler;
    private static CrashHandler crashHandler=new CrashHandler();
    private Context mContext;
    private Map<String,String> infos=new HashMap<String, String>();
    private SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    private CrashHandler() {}
    public void init(Context context){
        mContext=context;
        mExceptionHandler=Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        if(!handleException(throwable)&&mExceptionHandler!=null){
            mExceptionHandler.uncaughtException(thread, throwable);
        }else{
            SystemClock.sleep(3000);
            android.os.Process.killProcess(Process.myPid());
            System.exit(1);
        }
    }
    private boolean handleException(Throwable ex){
        if(ex==null){
            return false;
        }
        new Thread(){
            public void run() {
                Looper.prepare();
                Toast.makeText(mContext, "", Toast.LENGTH_SHORT).show();
                Looper.loop();
            };
        }.start();
        collectDeviceInfo(mContext);
        saveCrashInfo2File(ex);
        return true;
    }
    private String saveCrashInfo2File(Throwable ex) {
        StringBuilder sb=new StringBuilder();
        for (Map.Entry<String, String> entry:infos.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key+"="+value+"\n");
        }
        Writer writer=new StringWriter();
        PrintWriter printWriter=new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        Throwable cause = ex.getCause();
        while(cause!=null){
            cause.printStackTrace(printWriter);
            cause=cause.getCause();
        }
        printWriter.close();
        String result=writer.toString();
        sb.append(result);

        long timeStamp  = System.currentTimeMillis();
        String time = format.format(timeStamp);
        String fileName="crash-"+time+"-"+timeStamp+".log";
        File dir=new File(com.zzmstring.viewset.Utils.Constant.EXCEPTIONPATH);
        if(!dir.exists()){
            dir.mkdirs();
        }

        try {
            FileOutputStream fos=new FileOutputStream(com.zzmstring.viewset.Utils.Constant.EXCEPTIONPATH+fileName);
            fos.write(sb.toString().getBytes());
            fos.close();
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private void collectDeviceInfo(Context ct) {
        try {
            PackageManager manager=ct.getPackageManager();
            PackageInfo info = manager.getPackageInfo(ct.getPackageName(), PackageManager.GET_ACTIVITIES);
            if(info!=null){
                String versionName=info.versionName==null?"null":info.versionName;
                String versionCode = info.versionCode+"";
                infos.put("versionName", versionName);
                infos.put("versionCode", versionCode);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Field[] fields=Build.class.getDeclaredFields();
        for(Field field:fields){
            try {
                field.setAccessible(true);
                infos.put(field.getName(), field.get(null).toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static CrashHandler getCrashHandler(){
        return crashHandler;
    }
}
