package com.web.vo;

public class OrdersItem {
	private int item_id ;                  // 订单项  id
	private Goods goods ;       			 //订单项里边的商品信息
	private int item_quantity ;    			 // 订单项的数量
	private double item_singlePrice ;  		  //单品总价
	private String ord_id ;           	 	  //订单项对应的订单类的id
	
	
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getItem_quantity() {
		return item_quantity;
	}
	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}
	public double getItem_singlePrice() {
		return item_singlePrice;
	}
	public void setItem_singlePrice(double item_singlePrice) {
		this.item_singlePrice = item_singlePrice;
	}
	public String getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(String ord_id) {
		this.ord_id = ord_id;
	}
	@Override
	public String toString() {
		return "OrdersItem [item_id=" + item_id + ", goods=" + goods
				+ ", item_quantity=" + item_quantity + ", item_singlePrice="
				+ item_singlePrice + ", ord_id=" + ord_id + "]";
	}
	
	
	
}
