package com.web.idao;

import java.util.List;
import java.util.Map;

import com.web.vo.Goods;

public interface IGoodsDao {
	    //添加商品信息
		public int addGoods(Map<String,String> map) ;
		
		//查询所有商品 信息  
		public List<Goods> showGoods();
		
		//根据id查询商品信息  为修改做准备
		public Goods queryById(int id);
		
		//根据id修改商品信息
		 public int modGoods(Goods goods);
}
