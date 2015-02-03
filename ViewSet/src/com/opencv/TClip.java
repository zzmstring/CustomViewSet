package com.opencv;

import android.content.Context;


import android.graphics.Bitmap;



import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class TClip {

    private static final String TAG = "TClipJAVA";

    public static final String CONFIG = "haarcascade_frontalface_alt.xml";

    public static String copyConfig(Context context, String filename, int config) {

        String configPath = "/data/data/" + context.getPackageName() + "/" + filename;
        File configFile = new File(configPath);
        
        if (!configFile.exists()){

            InputStream in = null;
            OutputStream out = null;

            try {
                in = context.getResources().openRawResource(config);
                out = new FileOutputStream(configPath);

                byte[] buffer = new byte[1024];
                int read;
                while ((read = in.read(buffer)) != -1) {
                    out.write(buffer, 0, read);
                }
                in.close();
                in = null;
                out.flush();
                out.close();
                out = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return configPath;
    }

    //RGB_565 || ARGB_8888
    public static native Bitmap crop(String config, Bitmap src, int width, int height);

    static {
        try {
            System.loadLibrary("jtclip");
        } catch (UnsatisfiedLinkError ule) {
            ule.printStackTrace();
        }
    }

}
