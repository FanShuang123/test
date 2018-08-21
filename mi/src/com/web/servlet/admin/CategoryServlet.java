package com.web.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.CategoryDao;
import com.web.factory.DaoFactory;
import com.web.vo.Category;

public class CategoryServlet extends HttpServlet {
  String path=null;
  private Category category = null;
  private CategoryDao categoryDao= null;
  private List<Category> categoryList= null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
 
		 String action=request.getParameter("action");
		 
		 if(action.equals("addCategory")){
			 
			 addCategory(request,response);
		 }
		  else if (action.equals("showCategory")){
				
				showCategory(request,response);
		 }
		  else if("queryById".equals(action)){
			 queryById(request,response);
		 }
		  else if("modCategory".equals(action)){
			 modCategory(request,response);
		 }else if (action.equals("queryCategoryForGoods")){
			 queryCategoryForGoods(request,response);
		 }
		 
		 
		 //跳转
		request.getRequestDispatcher(path).forward(request, response);
	
	}
   private void queryCategoryForGoods(HttpServletRequest request,HttpServletResponse response) {
	   List<Category> categoryList =DaoFactory.getCategoryDao().queryCategoryForGoods();
	   
	    request.setAttribute("categoryList",categoryList);
	    
	    path="admin/main/addGoods.jsp";
		
	}
private void modCategory(HttpServletRequest request,HttpServletResponse response) {
	   int cat_id=Integer.parseInt(request.getParameter("cat_id"));
	   String cat_name=request.getParameter("cat_name");
	   String cat_desc=request.getParameter("cat_desc");
	   category = new Category();
	   category.setCat_id(cat_id);
	   category.setCat_name(cat_name);
	   category.setCat_desc(cat_desc);
	   
	 int num=  DaoFactory.getCategoryDao().modCategory(category);
	   
	  if(num>0){
		  path="categoryServlet?action=showCategory";
	  }else{
		  request.setAttribute("msg", "类别信息修改失败...");
		  path="/message.jsp";
	  }
		
	}
private void queryById(HttpServletRequest request,HttpServletResponse response) {
          int id=Integer.parseInt(request.getParameter("id"));
           category= DaoFactory.getCategoryDao().queryById(id);
           request.setAttribute("category",category);
	   
	   path="admin/main/modCategory.jsp";
	   
		
	}
				//显示所有类别信息
	private void showCategory(HttpServletRequest request,HttpServletResponse response) {
		 categoryList= DaoFactory.getCategoryDao().showCategory();
		  
		request.setAttribute("categoryList", categoryList);
		
		 path="admin/main/showCategory.jsp";
		
	}

	private void addCategory(HttpServletRequest request,HttpServletResponse response) {
		String cat_name=request.getParameter("cat_name");
		String cat_desc=request.getParameter("cat_desc");
		 category = new Category();
		 category.setCat_name(cat_name);
		 category.setCat_desc(cat_desc);
		  
		int num= DaoFactory.getCategoryDao().addCategory(category);
		if(num>0){
			//添加成功
			request.setAttribute("msg", "添加类别信息成功!!!");
		}
		else {
			//添加失败
			request.setAttribute("msg", "添加类别信息失败...");
		}     
		path = "/message.jsp" ;    //设置跳转路径
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
     doGet(request, response);

	}

}
