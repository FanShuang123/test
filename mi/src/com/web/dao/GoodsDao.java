package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.web.idao.IGoodsDao;
import com.web.util.DBInstance;
import com.web.vo.Category;
import com.web.vo.Goods;

public class GoodsDao implements IGoodsDao{
	/*   private Connection conn=null;*/
	   private PreparedStatement pre=null;
	   private ResultSet rs=null;
	   private Category category=null;
	   private Goods goods=null;
	   String sql=null;
	 //添加商品信息
	public int addGoods(Map<String,String> map) {
		// TODO Auto-generated method stub
		sql="insert into goods(goods_name,goods_price,goods_img,cat_id) values(?,?,?,?)" ;
		try {
			pre=DBInstance.getConn().prepareStatement(sql);
			pre.setString(1,map.get("goods_name"));
			pre.setDouble(2,Double.parseDouble(map.get("goods_price")));
			pre.setString(3,map.get("goods_img"));
		
			pre.setInt(4, Integer.parseInt(map.get("cat_id")));
		
			 int num=pre.executeUpdate();
			 
			 return num;
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	@Override
	public List<Goods> showGoods() {
		sql="select * from goods";
		List<Goods> list=new ArrayList<Goods>();
		try {
			pre=DBInstance.getConn().prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()){
				goods=new Goods();
				goods.setGoods_id(rs.getInt("goods_id"));
				goods.setGoods_name(rs.getString("goods_name"));
				goods.setGoods_price(rs.getDouble("goods_price"));
				goods.setGoods_img(rs.getString("goods_img"));
				category=new Category();
				category.setCat_id(rs.getInt("cat_id"));
				goods.setCategory(category);
				
				list.add(goods);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	//根据id查询商品信息  为修改做准备
	public Goods queryById(int id) {
		sql="select * from goods where goods_id=?";
		 
		try {
			pre=DBInstance.getConn().prepareStatement(sql);
			pre.setInt(1,id);
			rs=pre.executeQuery();
			if(rs.next()){
				
				goods=new Goods();
				goods.setGoods_id(rs.getInt("goods_id"));
				goods.setGoods_name(rs.getString("goods_name"));
				goods.setGoods_price(rs.getDouble("goods_price"));
				goods.setGoods_img(rs.getString("goods_img"));
				
				category=new Category();
			    category.setCat_id(rs.getInt(5));
			    //System.out.println(rs.getInt(3));
			    goods.setCategory(category);
			    
			    //这么写对么>↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
				/*goods.setCategory(category.setCat_id(rs.getInt("cat_id")));*/
				
			}return goods;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	//根据id修改商品信息
	public int modGoods(Goods goods) {
		sql="update goods set goods_id=?,goods_name=?,goods_price=?,goods_img=?,cat_id=? where goods_id=?";
   try { pre=DBInstance.getConn().prepareStatement(sql);
         pre.setInt(1,goods.getGoods_id());
         pre.setString(2,goods.getGoods_name());
         pre.setDouble(3,goods.getGoods_price());
         pre.setString(4,goods.getGoods_img());
         category=goods.getCategory();
         pre.setInt(5,category.getCat_id());
         
         
         pre.setInt(6,goods.getGoods_id());
         
       int num=  pre.executeUpdate(); 
		return num;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
