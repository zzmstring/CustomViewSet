/**
 *
 *	created by Mr.Simple, Sep 30, 201411:50:14 PM.
 *	Copyright (c) 2014, hehonghui@umeng.com All Rights Reserved.
 *
 *                #####################################################
 *                #                                                   #
 *                #                       _oo0oo_                     #   
 *                #                      o8888888o                    #
 *                #                      88" . "88                    #
 *                #                      (| -_- |)                    #
 *                #                      0\  =  /0                    #   
 *                #                    ___/`---'\___                  #
 *                #                  .' \\|     |# '.                 #
 *                #                 / \\|||  :  |||# \                #
 *                #                / _||||| -:- |||||- \              #
 *                #               |   | \\\  -  #/ |   |              #
 *                #               | \_|  ''\---/''  |_/ |             #
 *                #               \  .-\__  '-'  ___/-. /             #
 *                #             ___'. .'  /--.--\  `. .'___           #
 *                #          ."" '<  `.___\_<|>_/___.' >' "".         #
 *                #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 *                #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 *                #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 *                #                       `=---='                     #
 *                #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 *                #                                                   #
 *                #               佛祖保佑         永无BUG              #
 *                #                                                   #
 *                #####################################################
 */

package com.zzmstring.viewset.UI.every.refresh;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.uit.commons.CommonAdapter;
import com.uit.commons.CommonViewHolder;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.RefreshAndLoading.pullrefresh.listener.OnLoadListener;
import com.zzmstring.viewset.View.RefreshAndLoading.pullrefresh.listener.OnRefreshListener;
import com.zzmstring.viewset.View.RefreshAndLoading.pullrefresh.scroller.impl.RefreshGridView;
import com.zzmstring.viewset.View.RefreshAndLoading.pullrefresh.scroller.impl.RefreshListView;
import com.zzmstring.viewset.View.RefreshAndLoading.pullrefresh.scroller.impl.RefreshSlideDeleteListView;
import com.zzmstring.viewset.View.RefreshAndLoading.pullrefresh.scroller.impl.RefreshTextView;
import com.zzmstring.viewset.View.RefreshAndLoading.pullrefresh.swipe.RefreshLayout;
import com.zzmstring.viewset.View.RefreshAndLoading.pullrefresh.swipe.RefreshLvLayout;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author mrsimple
 */
public class ShowActivity extends Activity {

    public static final int REFRESH_LV = 1;
    public static final int REFRESH_GV = 2;
    public static final int REFRESH_TV = 3;
    public static final int REFRESH_SLIDE_LV = 4;
    public static final int SWIPE_LV = 5;

    //
    final List<String> dataStrings = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int index = 0;
        Bundle extraBundle = getIntent().getExtras();
        if (extraBundle != null && extraBundle.containsKey("index")) {
            index = extraBundle.getInt("index");
        }

        // 准备数据
        for (int i = 0; i < 20; i++) {
            dataStrings.add("item - " + i);
        }

        switch (index) {
            case REFRESH_LV:
                setListView();
                break;
            case REFRESH_GV:
                setGridView();
                break;
            case REFRESH_TV:
                setTextView();
                break;
            case REFRESH_SLIDE_LV:
                setSlideListView();
                break;
            case SWIPE_LV:
                setSwipeRefreshListView();
                break;
            default:
                break;
        }
    }

    /**
     * 
     */
    private void setListView() {
        final RefreshListView refreshLayout = new RefreshListView(this);

        // 获取ListView, 这里的listview就是Content view
        refreshLayout.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, dataStrings));
        // 设置下拉刷新监听器
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {

            @Override
            public void onRefresh() {
                Toast.makeText(getApplicationContext(), "refreshing", Toast.LENGTH_SHORT)
                        .show();

                refreshLayout.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        refreshLayout.refreshComplete();
                    }
                }, 1500);
            }
        });

        // 不设置的话到底部不会自动加载
        refreshLayout.setOnLoadListener(new OnLoadListener() {

            @Override
            public void onLoadMore() {
                Toast.makeText(getApplicationContext(), "loading", Toast.LENGTH_SHORT)
                        .show();

                refreshLayout.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        refreshLayout.loadCompelte();
                    }
                }, 1500);
            }
        });

        //
        setContentView(refreshLayout);
    }

    /**
     * 
     */
    private void setGridView() {
        // gridview
        final RefreshGridView gv = new RefreshGridView(this);
        String[] dataStrings = new String[20];
        for (int i = 0; i < dataStrings.length; i++) {
            dataStrings[i] = "item - " +
                    i;
        }
        gv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, dataStrings));
        //
        gv.setOnRefreshListener(new OnRefreshListener() {

            @Override
            public void onRefresh() {
                Toast.makeText(getApplicationContext(), "refreshing", Toast.LENGTH_SHORT)
                        .show();

                gv.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        gv.refreshComplete();
                    }
                }, 1500);
            }
        });

        // 不设置的话到底部不会自动加载
        gv.setOnLoadListener(new OnLoadListener() {

            @Override
            public void onLoadMore() {
                Toast.makeText(getApplicationContext(), "loading", Toast.LENGTH_SHORT)
                        .show();

                gv.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        gv.loadCompelte();
                    }
                }, 1500);
            }
        });

        setContentView(gv);

    }

    /**
     * 
     */
    private void setTextView() {
        final RefreshTextView refreshTextView = new RefreshTextView(this);
        //
        final TextView tv = refreshTextView.getContentView();
        tv.setText("下拉更新时间的TextView");
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(30f);
        tv.setBackgroundColor(Color.YELLOW);
        refreshTextView.setOnRefreshListener(new OnRefreshListener() {

            @Override
            public void onRefresh() {
                refreshTextView.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        SimpleDateFormat sdf = (SimpleDateFormat) SimpleDateFormat.getInstance();
                        sdf.applyPattern("yyyy-MM-dd hh:mm:ss");
                        refreshTextView.getContentView().setText("下拉更新时间的TextView " +
                                System.getProperty("line.separator") + sdf.format(new Date()));
                        refreshTextView.refreshComplete();
                    }
                }, 1500);
            }
        });
        //
        setContentView(refreshTextView);
    }

    // 适配器
    final BaseAdapter myAdapter = new CommonAdapter<String>(this,
            R.layout.slide_item_layout,
            dataStrings) {

        @Override
        protected void fillItemData(CommonViewHolder viewHolder, final int
                position,
                String item) {

            viewHolder.setTextForTextView(R.id.text_tv, item);
            //
            viewHolder.setOnClickListener(R.id.delete, new OnClickListener() {

                @Override
                public void onClick(View v) {
                    //
                    slideDeleteListView.onRemoveItem(position);
                    dataStrings.remove(position);
                    myAdapter.notifyDataSetChanged();
                }
            });
        }
    };

    RefreshSlideDeleteListView slideDeleteListView;

    /**
     * 
     */
    private void setSlideListView() {

        slideDeleteListView = new RefreshSlideDeleteListView(this);

        //
        slideDeleteListView.setAdapter(myAdapter);
        //
        slideDeleteListView.setOnRefreshListener(new OnRefreshListener() {

            @Override
            public void onRefresh() {
                slideDeleteListView.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        slideDeleteListView.refreshComplete();
                    }
                }, 1500);
            }
        });
        //
        setContentView(slideDeleteListView);
    }

    /**
     * 
     */
    private void setSwipeRefreshListView() {
        //
        setContentView(R.layout.swipe_lv_layout);

        // 注意, 这是一个ViewGroup类, 不是listview本身
        final RefreshLvLayout refreshLayout = (RefreshLvLayout) findViewById(R.id.swipe_layout);
        // 注意这里的是SwipeRefreshLayout.OnRefreshListener
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {

                Toast.makeText(getApplicationContext(), "on refresh ", Toast.LENGTH_SHORT).show();

                // 如果没有时间消耗,那么加载效果很快消失了
                refreshLayout.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        // 刷新完以后调用该方法
                        refreshLayout.setRefreshing(false);
                    }
                }, 1500);
            }
        });

        // 滑动到底部再上拉则加载横多
        refreshLayout.setOnLoadListener(new RefreshLayout.OnLoadListener() {

            @Override
            public void onLoad() {
                Toast.makeText(getApplicationContext(), "on load ( 加载1.5秒 )", Toast.LENGTH_SHORT)
                        .show();
                // 如果没有时间消耗,那么加载效果很快消失了，相当于没有显示footer视图一样.
                refreshLayout.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        // 加载完以后调用该方法
                        refreshLayout.setLoading(false);
                    }
                }, 1500);
            }
        });

        // listview
        final ListView listView = (ListView) findViewById(R.id.swipe_listview);

        // 设置适配器
        listView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, dataStrings));
    }
}
