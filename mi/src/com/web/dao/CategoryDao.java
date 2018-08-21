package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.idao.ICategoryDao;
import com.web.util.DBInstance;
import com.web.vo.Category;

public class CategoryDao implements ICategoryDao{
	
		 private Connection conn = null;
		 private PreparedStatement pre = null;
		 private ResultSet rs = null;
		 private String sql = null;
		 private List<Category> categoryList=null;
		 private Category category=null;
	
	public int addCategory(Category category) {
		
		try {
			sql = "insert into category (cat_name,cat_desc) values(?,?)";
			pre = DBInstance.getConn().prepareStatement(sql);
			pre.setString(1,category.getCat_name());
			pre.setString(2,category.getCat_desc());
			int num=pre.executeUpdate();
			
			return num;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0 ;
		}finally{
			DBInstance.close(pre,conn);
		}
	
	}

	
	//查询所有类别名称                  为 goods的添加做显示操作
	public List<Category> queryCategoryForGoods() {
		List<Category> categoryList=null;
		sql="select * from category";
		try {
			pre=DBInstance.getConn().prepareStatement(sql);
			rs=pre.executeQuery();
			categoryList=new ArrayList<Category>();
		     while(rs.next()){
		    	category = new Category();
		    	
		    	category.setCat_id(rs.getInt("cat_id"));
		    	category.setCat_name(rs.getString("cat_name"));
		    	category.setCat_desc(rs.getString("cat_desc"));
		    	categoryList.add(category);
		     }
		     
			  return categoryList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}

 //展示所有类别信息,
	public List<Category> showCategory() {
		
		try {
			sql = "select * from category";
			pre=DBInstance.getConn().prepareStatement(sql);
			rs=pre.executeQuery();
			categoryList = new ArrayList<Category>();
			while(rs.next()){
				category=new Category();
				category.setCat_id(rs.getInt("cat_id"));
				category.setCat_name(rs.getString("cat_name"));
				category.setCat_desc(rs.getString("cat_desc"));
				
				categoryList.add(category);
				
			}
			
			return categoryList;
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
		
	}

	
	public Category queryById(int id) {
		sql="select * from category where cat_id=?";
		try {
			pre=DBInstance.getConn().prepareStatement(sql);
			
			pre.setInt(1, id);
			rs=pre.executeQuery();
			if(rs.next()){
				category = new Category();
				category.setCat_id(rs.getInt("cat_id"));
				category.setCat_name(rs.getString("cat_name"));
				category.setCat_desc(rs.getString("cat_desc"));
			
			}
			return category;
			
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Category> queryInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modCategory(Category category) {
		sql="update category set cat_name=?,cat_desc=? where cat_id=?";  //cat_id=?,
		try {
			pre=DBInstance.getConn().prepareStatement(sql);
			pre.setString(1, category.getCat_name());
			pre.setString(2, category.getCat_desc());
			pre.setInt(3,category.getCat_id());
			
			int num=pre.executeUpdate();
			return num;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}



	
	
	
}
	
	
