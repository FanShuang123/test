package com.web.factory;

import com.web.dao.CategoryDao;
import com.web.dao.GoodsDao;
import com.web.dao.OrdersDao;
import com.web.dao.PageDao;
import com.web.dao.UsersDao;
import com.web.idao.ICategoryDao;
import com.web.idao.IGoodsDao;
import com.web.idao.IOrdersDao;
import com.web.idao.IPageDao;
import com.web.idao.IUsersDao;

public class DaoFactory {
	
	public static ICategoryDao getCategoryDao(){
		return new CategoryDao();
		
	}
	public static IGoodsDao getGoodsDao(){
		return new GoodsDao();
		
	}
	public static IUsersDao getUsersDao(){
		return new UsersDao();
		
	}
	public static IPageDao getPageDao(){
		return new PageDao();
		
		
	}public static IOrdersDao getOrdersDao(){
		return new OrdersDao();
		
		
	}

}
