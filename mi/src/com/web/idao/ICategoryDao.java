package com.web.idao;

import java.util.List;

import com.web.vo.Category;

public interface ICategoryDao {
	
	 //  添加类别
		public int addCategory(Category category) ;
		//查询所有类别名称   为goods做显示操作
	      public List<Category> queryCategoryForGoods() ;   
	      
	    //查询所有类别信息   显示
	      public List<Category> showCategory() ; 
	      
	      //查询单个类别  为修改做准备   
	      public Category queryById(int id) ; 
	      
	      //查询所有类别名称  显示到clt_center.jsp
	      public List<Category> queryInfo() ;
	      
	      
	      //修改category  类别信息
	      public int modCategory(Category category);
		
}
