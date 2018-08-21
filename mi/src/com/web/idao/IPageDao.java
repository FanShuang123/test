package com.web.idao;

import java.util.List;

import com.web.vo.Goods;

public interface IPageDao {
	// 计算总记录个数
	public int getTotalCount();
	 
	//每一页展示的商品信息
	public List<Goods> getGoodsList(int startIndex, int pageCount);
}
