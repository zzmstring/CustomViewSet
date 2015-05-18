package com.zzmstring.viewset.UI.other;

import android.os.Bundle;

import com.lidroid.xutils.ViewUtils;
import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;

/**
 * Created by zzmstring on 2015/5/18.
 */
public class GanjiAty extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.aty_mylayout);
        ViewUtils.inject(this);
    }

}
