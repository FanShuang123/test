package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.idao.IPageDao;
import com.web.util.DBInstance;
import com.web.vo.Category;
import com.web.vo.Goods;

public class PageDao implements IPageDao{

	
	   private Connection conn=null;
	   private PreparedStatement pre=null;
	   private ResultSet rs=null;
	   private Category category=null;
	   private Goods goods=null;
	   private List<Goods> goodsList=null;
	   private String sql=null;
	   
	   
	//得到总记录个数
	public int getTotalCount() {
      
      	try {
      		sql="select count(*) 总记录数  from goods";
			rs=DBInstance.getConn().prepareStatement(sql).executeQuery();
			if(rs.next()){
				return rs.getInt("总记录数");
			}else {
				return 0;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			DBInstance.close(rs, pre, conn);
			
		}
		
	}

	
	public List<Goods> getGoodsList(int startIndex, int pageCount) {
		
		
		try {
			sql="select * from goods limit ?,?";
			pre=DBInstance.getConn().prepareStatement(sql);
			pre.setInt(1, startIndex);
			pre.setInt(2, pageCount);
			rs=pre.executeQuery();
		 goodsList=new ArrayList<Goods>();
		 while(rs.next()){
			 goods=new Goods();
			 
			 goods.setGoods_id(rs.getInt("goods_id"));
			 goods.setGoods_name(rs.getString("goods_name"));
			 goods.setGoods_price(rs.getDouble("goods_price"));
			 goods.setGoods_img(rs.getString("goods_img"));
			 category = new Category();
			 category.setCat_id(rs.getInt("cat_id"));
			 goods.setCategory(category);
			 goodsList.add(goods);
			 
			 
			 
		 }return goodsList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	
		
	}

}
