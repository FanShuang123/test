package com.web.servlet.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.factory.DaoFactory;
import com.web.util.Page;
import com.web.vo.Category;
import com.web.vo.Goods;

public class IndexServlet extends HttpServlet {
       
    String path=null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		
		String action=request.getParameter("action");
		if(action.equals("queryAll")){
			//System.out.println(action);
			queryAll(request,response);
		}
		
		
	}

	
	private void queryAll(HttpServletRequest request,HttpServletResponse response) throws ServletException {
		
		 List<Category> categoryList= DaoFactory.getCategoryDao().queryCategoryForGoods();
		 
		
		//List<Goods> goodsList=DaoFactory.getGoodsDao().showGoods();
		 
		 String pageNum=request.getParameter("pageNum");
		 Page page=new Page(pageNum);
		 
		 
		 
		// List<Goods> goodList = DaoFactory.getPageDao().getGoodsList(startIndex, pageCount);
		HttpSession session=request.getSession();
		 session.setAttribute("categoryList", categoryList);
		session.setAttribute("page", page);
		//request.setAttribute("goodsList", goodsList);
		
		//HttpSession session=request.getSession();

		//request.setAttribute("goodsList", goodsList);
		//重定向  可以试试  session 传值  
		
			 path="client/goodsList.jsp";
		  /*path ="client/showGoods.jsp" ;*/
			try {
			response.sendRedirect(path);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	
		 

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

}
