package com.zzmstring.viewset.Bean;

public class ChannelItem {
	private int id;
	private String name;
	private int orderid;
	private int[] rgbs;
	private int typeid;
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int[] getRgbs() {
		return rgbs;
	}
	public void setRgbs(int[] rgbs) {
		this.rgbs = rgbs;
	}
	public ChannelItem() {
		super();
	}
	public ChannelItem(int id, String name, int orderid, int[] rgbs, int typeid) {
		super();
		this.id = id;
		this.name = name;
		this.orderid = orderid;
		this.rgbs = rgbs;
		this.typeid = typeid;
	}
	
}
