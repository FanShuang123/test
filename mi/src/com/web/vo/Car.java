package com.web.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Car {

	private Map<Integer,CarItem> map = new HashMap<Integer,CarItem>() ;
	
	 ///购物车总价
	private double totalPrice ;
	
	
	@Override
	public String toString() {
		return "Car [map=" + map + ", totalPrice=" + totalPrice + "]";
	}
	public Map<Integer, CarItem> getMap() {
		return map;
	}
	public void setMap(Map<Integer, CarItem> map) {
		this.map = map;
	}
	 //获得购物车商品总价
	public double getTotalPrice() {
		this.totalPrice = 0 ;
		Set<Entry<Integer, CarItem>> set=map.entrySet();
		for(Entry<Integer, CarItem> entry:set){
			CarItem  carItem=entry.getValue(); //得到
			this.totalPrice = this.totalPrice + carItem.getSinglePrice() ;	
		}
		
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
