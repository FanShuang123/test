package com.web.vo;

public class CarItem {
	   //商品信息
		private Goods goods ;
		//购买数量
		private int quantity ;
		//单品总价
		private double singlePrice ;
		
		
		@Override
		public String toString() {
			return "CarItem [goods=" + goods + ", quantity=" + quantity
					+ ", singlePrice=" + singlePrice + "]";
		}
		public Goods getGoods() {
			return goods;
		}
		public void setGoods(Goods goods) {
			this.goods = goods;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		//得到单品总价
		public double getSinglePrice() {
			this.singlePrice=this.quantity * this.goods.getGoods_price();
			return singlePrice;
		}
		public void setSinglePrice(double singlePrice) {
			
			this.singlePrice = singlePrice;
		}
		public CarItem() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
}
