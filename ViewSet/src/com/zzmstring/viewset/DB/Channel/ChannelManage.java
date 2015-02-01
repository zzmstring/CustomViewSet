package com.zzmstring.viewset.DB.Channel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;




import android.database.SQLException;
import android.util.Log;

import com.zzmstring.viewset.Bean.ChannelItem;

public class ChannelManage {
	public static ChannelManage channelManage;
	/**
	 * 默认的用户选择频道列表
	 * */
	public static List<ChannelItem> defaultUserChannels;
	private ChannelDao channelDao;
	/** 判断数据库中是否存在用户数据 */
	private boolean userExist = false;
	static {
		int[] rgbs1={219,72,78};
		int[] rgbs2={229,192,103};
		int[] rgbs3={86,159,229};
		int[] rgbs4={65,197,229};
		int[] rgbs5={210,177,120};
		int[] rgbs6={196,99,214};
		List<int[]> listrgb=new ArrayList<int[]>();
		listrgb.add(rgbs1);
		listrgb.add(rgbs2);
		listrgb.add(rgbs3);
		listrgb.add(rgbs4);
		listrgb.add(rgbs5);
		listrgb.add(rgbs6);
		defaultUserChannels = new ArrayList<ChannelItem>();
		defaultUserChannels.add(new ChannelItem(1, "一级建造师", 1, listrgb.get(0),24));
		defaultUserChannels.add(new ChannelItem(2, "中级会计职称", 2, listrgb.get(1),23));
		defaultUserChannels.add(new ChannelItem(3, "职称英语", 3, listrgb.get(2),25));
		defaultUserChannels.add(new ChannelItem(4, "初级会计职称", 4, listrgb.get(3),27));
		defaultUserChannels.add(new ChannelItem(5, "注册会计师", 5, listrgb.get(4),107));
		defaultUserChannels.add(new ChannelItem(6, "剑桥商务英语BEC", 6, listrgb.get(5),114));
	}

	private ChannelManage(SQLHelper paramDBHelper) throws SQLException {
		if (channelDao == null)
			channelDao = new ChannelDao(paramDBHelper.getContext());
		// NavigateItemDao(paramDBHelper.getDao(NavigateItem.class));
		return;
	}

	/**
	 * 初始化频道管理类
	 * @param paramDBHelper
	 * @throws android.database.SQLException
	 */
	public static ChannelManage getManage(SQLHelper dbHelper)throws SQLException {
		if (channelManage == null)
			channelManage = new ChannelManage(dbHelper);
		return channelManage;
	}

	/**
	 * 清除所有的频道
	 */
	public void deleteAllChannel() {
		channelDao.clearFeedTable();
	}
	/**
	 * 获取其他的频道
	 * @return 数据库存在用户配置 ? 数据库内的用户选择频道 : 默认用户选择频道 ;
	 */
	public List<ChannelItem> getUserChannel() {
		Object cacheList = channelDao.listCache(null,null);
		if (cacheList != null && !((List) cacheList).isEmpty()) {
			userExist = true;
			List<Map<String, String>> maplist = (List) cacheList;
			int count = maplist.size();
			List<ChannelItem> list = new ArrayList<ChannelItem>();
			for (int i = 0; i < count; i++) {
				ChannelItem navigate = new ChannelItem();
				navigate.setId(Integer.valueOf(maplist.get(i).get(SQLHelper.ID)));
				navigate.setName(maplist.get(i).get(SQLHelper.NAME));
				navigate.setOrderid(Integer.valueOf(maplist.get(i).get(SQLHelper.ORDERID)));
				int[] rgbs=new int[3];
				rgbs[0]=Integer.valueOf(maplist.get(i).get("red"));
				rgbs[1]=Integer.valueOf(maplist.get(i).get("green"));
				rgbs[2]=Integer.valueOf(maplist.get(i).get("blue"));
				navigate.setRgbs(rgbs);
				navigate.setTypeid(Integer.valueOf(maplist.get(i).get("typeid")));
				list.add(navigate);
			}
			return list;
		}
		initDefaultChannel();
		return defaultUserChannels;
	}
	
	
	
	/**
	 * 保存用户频道到数据库
	 * @param userList
	 */
	public void saveUserChannel(List<ChannelItem> userList) {
		for (int i = 0; i < userList.size(); i++) {
			ChannelItem channelItem = (ChannelItem) userList.get(i);
			channelItem.setOrderid(i);
			channelDao.addCache(channelItem);
		}
	}
	
	
	/**
	 * 初始化数据库内的频道数据
	 */
	private void initDefaultChannel(){
		Log.d("deleteAll", "deleteAll");
		deleteAllChannel();
		saveUserChannel(defaultUserChannels);
	}
}
