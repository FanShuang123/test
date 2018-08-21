package com.web.util;

import java.util.List;

import com.web.factory.DaoFactory;
import com.web.vo.Goods;

public class Page {
	
	
	private int totalCount;  //总记录数
	private int totalPageCount;  //总页数
	private int startIndex;  //起始下标
	private int pageCount = 10;   //每页显示记录个
	private List<Goods> goodsList;  //每页商品信息
	private int pageNum;   //当前页数
	
	public Page() {
		
	}
	public Page(String pageNum) {
		//获取总记录个数
		this.totalCount=DaoFactory.getPageDao().getTotalCount();
		 
		//计算总共分页数         总记录数 % 步长(每页)
		if(this.totalCount % this.pageCount ==0){
			this.totalPageCount=this.totalCount / this.pageCount;
		}else{
			this.totalPageCount=this.totalCount / this.pageCount +1;
		}
		if(pageNum==null){
			this.pageNum=1;
		}else{
			this.pageNum=Integer.parseInt(pageNum);
		}
		
		//获得用户需要显示的页数
		/*this.pageNum=1;*/
		
		// 计算  起始下标
		this.startIndex=(this.pageNum-1) * this.pageCount;
		
		//获得当前页显示数据内容
		this.goodsList=DaoFactory.getPageDao().getGoodsList(this.startIndex, this.pageCount);
				
	
		
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public int getTotalPageCount() {
		return totalPageCount;
	}


	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}


	public int getStartIndex() {
		return startIndex;
	}


	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}


	public int getPageCount() {
		return pageCount;
	}


	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


	public List<Goods> getGoodsList() {
		return goodsList;
	}


	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}


	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	

	
	
}
