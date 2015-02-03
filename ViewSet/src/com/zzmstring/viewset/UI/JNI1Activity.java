package com.zzmstring.viewset.UI;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.Image.FastBlur;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.Utils.ExLog;

/**
 * Created by ZGL on 2015/2/2.
 */
public class JNI1Activity extends BaseActivity{
    @ViewInject(R.id.iv_mainjni)
    ImageView iv_mainjni;
    @ViewInject(R.id.tv_text)
    View tv_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void initView() {
        setContentView(R.layout.activity_jni1);
        ViewUtils.inject(this);


        applyBlur();

    }
    @Override
    public void initListener() {

    }

    /**
     *
     */
    @Override
    public void initData() {

    }
    private void applyBlur() {
        iv_mainjni.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                iv_mainjni.getViewTreeObserver().removeOnPreDrawListener(this);
                iv_mainjni.buildDrawingCache();
                Bitmap bmp = iv_mainjni.getDrawingCache();
                boolean is=bmp==null;
                ExLog.l("bmp==null>>"+is);
                blur(bmp, tv_text);
                return true;
            }
        });
    }
    private void blur(Bitmap bkg, View view) {
        ExLog.l("执行了"+ExLog.getCurrentMethodName());
        long startMs = System.currentTimeMillis();
        float scaleFactor = 1;
        float radius = 20;
        Bitmap overlay = Bitmap.createBitmap((int) (view.getMeasuredWidth() / scaleFactor),
                (int) (view.getMeasuredHeight() / scaleFactor), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(overlay);
        canvas.translate(-view.getLeft() / scaleFactor, -view.getTop() / scaleFactor);
        canvas.scale(1 / scaleFactor, 1 / scaleFactor);
        Paint paint = new Paint();
        paint.setFlags(Paint.FILTER_BITMAP_FLAG);
        canvas.drawBitmap(bkg, 0, 0, paint);
        overlay = FastBlur.doBlurJniBitMap(overlay, (int) radius, true);
        view.setBackgroundDrawable(new BitmapDrawable(getResources(), overlay));

    }

}
