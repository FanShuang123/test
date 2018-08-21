package com.web.idao;

import java.util.List;

import com.web.vo.Orders;
import com.web.vo.OrdersItem;
import com.web.vo.Users;

public interface IOrdersDao {
	//  添加订单
	 public int addOrders(Orders orders);
	 
	//  添加订单项
		 public int addOrdersItem(Orders orders);
		 
		 
		//  根据订单订单支付状态查询  为结算做准备     现在还没用
	public List<Orders> queryOrdersByStatue(boolean status);	
	
	//  根据用户和支付状态查询用户没支付的订单  并且排序   
	public List<Orders> queryOrdersByStatueAndUsers(boolean status,Users users);	
	
    //  根据用户和支付状态查询用户一个没支付的订单 
	public Orders queryOneOrdersById(String ord_id);	
	
	//修改订单状态  产生积分给用户    状态改成true  积分也加了 存放到Orders里边  user score添加
	public Orders payOrders(Orders orders,boolean status,double score);
	
	//查询用户所有已经支付的订单  根据用户id 
	 public List<Orders>queryOrdersByStatueAndUsersIsPay(int users_id);
	 
		//根据订单创建时间 给用户的订单进行排序        
	 public List<Orders> queryOrdersByUserAndOrderByOrd_status(boolean status,Users users,int i);
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
