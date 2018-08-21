package com.web.vo;

public class Goods {
	private int goods_id ;
	private String goods_name ;
	private double goods_price ;
	private String goods_img ;
	private Category category ;
	
	
	public String toString() {
		return "Goods [goods_id=" + goods_id + ", goods_name=" + goods_name
				+ ", goods_price=" + goods_price + ", goods_img=" + goods_img
				+ ", category=" + category + "]";
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
