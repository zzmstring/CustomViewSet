package com.zzmstring.viewset.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zzmstring.viewset.R;
import com.zzmstring.viewset.Utils.RandomColor.RandomColor;


/**
 * Created by zzmx on 2015/1/27.
 */
public class TestAdapter extends BaseAdapter {
    RandomColor randomColor;
    private Context context;
    public TestAdapter(Context context){
        this.context=context;
        randomColor=new RandomColor();
    }
    @Override
    public int getCount() {
        return 30;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=View.inflate(context, R.layout.item_test,null);
        view.setBackgroundColor(randomColor.randomColor());
        return view;
    }
    public static class ViewHolder{
        TextView tv_test;
    }
}
