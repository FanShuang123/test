package com.web.vo;

import java.util.Date;
import java.util.List;

public class Orders {
	
	private String ord_id ;
	
	private List<OrdersItem> ord_itemList ;//订单项
	
	private double ord_totalPrice ; //订单总价
	
	private double ord_score ; //订单可以生成的积分    和 订单总价一样

	private Date ord_time ;      //订单生成时间
	
	private Date ord_payTime ;      //订单支付时间
	
	private boolean ord_statue ;   //订单是否结算 
	
	private Users users ;    //哪个人的订单?	
	
	
	
	public double getOrd_score() {
		
	//	this.ord_score=this.ord_totalPrice;
		return ord_score;
	}

	public void setOrd_score(double ord_score) {
		this.ord_score = ord_score;
	}


	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOrd_id() {
		return ord_id;
	}

	public void setOrd_id(String ord_id) {
		this.ord_id = ord_id;
	}

	public List<OrdersItem> getOrd_itemList() {
		return ord_itemList;
	}

	public void setOrd_itemList(List<OrdersItem> ord_itemList) {
		this.ord_itemList = ord_itemList;
	}

	public double getOrd_totalPrice() {
		return ord_totalPrice;
	}

	public void setOrd_totalPrice(double ord_totalPrice) {
		this.ord_totalPrice = ord_totalPrice;
	}

	public Date getOrd_time() {
		return ord_time;
	}

	public void setOrd_time(Date ord_time) {
		this.ord_time = ord_time;
	}

	public boolean isOrd_statue() {
		return ord_statue;
	}

	public void setOrd_statue(boolean ord_statue) {
		this.ord_statue = ord_statue;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Orders [ord_id=" + ord_id + ", ord_itemList=" + ord_itemList
				+ ", ord_totalPrice=" + ord_totalPrice + ", ord_score="
				+ ord_score + ", ord_time=" + ord_time + ", ord_payTime="
				+ ord_payTime + ", ord_statue=" + ord_statue + ", users="
				+ users + "]";
	}

	public Date getOrd_payTime() {
		return ord_payTime;
	}

	public void setOrd_payTime(Date ord_payTime) {
		this.ord_payTime = ord_payTime;
	}



	
	

}
