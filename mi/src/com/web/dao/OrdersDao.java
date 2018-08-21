package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.idao.IOrdersDao;
import com.web.util.DBInstance;
import com.web.vo.Category;
import com.web.vo.Goods;
import com.web.vo.Orders;
import com.web.vo.OrdersItem;
import com.web.vo.Users;

public class OrdersDao implements IOrdersDao{
	   private Connection conn=null;
	   private PreparedStatement pre=null;
	   private ResultSet rs=null;
	   private Category category=null;
	   private Goods goods=null;
	   String sql=null;
	   private Connection conn2=null;
	   private PreparedStatement pre2=null;
	   private ResultSet rs2=null;
	   String sql2=null;
	   private Connection conn1=null;
	   private PreparedStatement pre1=null;
	   private ResultSet rs1=null;
	   String sql1=null;
	   private Connection conn3=null;
	   private PreparedStatement pre3=null;
	   private ResultSet rs3=null;
	   String sql3=null;
	   int num=0;
	   int num1=0;
	   
	   
	   OrdersItem ordersItem=null;
	   List<OrdersItem> itemList=null;
	   List<Orders> ordersList=null;
	   Orders orders=null;
	   Users users=null;
	   
	   //添加订单方法
	public int addOrders(Orders orders) {
		// 先建立ord_id   因为是外键,  不然没法添值?
		  try {
		    sql="insert into orders (ord_id,ord_totalPrice,ord_score,ord_status,ord_time,user_id) values(?,?,?,?,now(),?)";
			pre=DBInstance.getConn().prepareStatement(sql);
			pre.setString(1, orders.getOrd_id());
			pre.setDouble(2,orders.getOrd_totalPrice());
			pre.setDouble(3,orders.getOrd_score());
			pre.setBoolean(4,orders.isOrd_statue());
			pre.setInt(5,orders.getUsers().getUsers_id());
			//System.out.println(orders.getUsers().getUsers_id()+"~~~~~~~~~~~~");
			
	         num=pre.executeUpdate();
			
			
		return num;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}finally{
			DBInstance.close(pre,conn);
		}
		
	}



	@Override
	public int addOrdersItem(Orders orders) {
		// TODO Auto-generated method stub
		//sql="insert into ordersItem (goods_id,item_quantity,item_singlePrice,ord_id) values(?,?,?,?)";
		try {
			 sql="insert into ordersItem (goods_id,item_quantity,item_singlePrice,ord_id) values(?,?,?,?)";
			 pre=DBInstance.getConn().prepareStatement(sql);
			 List<OrdersItem>  itemList=orders.getOrd_itemList();
			 for(OrdersItem ordersItem: itemList){
				  //System.out.println(ordersItem);
				pre.setInt(1,ordersItem.getGoods().getGoods_id());
				pre.setInt(2,ordersItem.getItem_quantity());
				pre.setDouble(3,ordersItem.getItem_singlePrice());
				pre.setString(4, ordersItem.getOrd_id());
			 
				num1 = pre.executeUpdate();
			 }
			 return num1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
		   DBInstance.close(rs,pre,conn);
		}
	}
//  根据订单订单支付状态查询  为结算做准备           //暂时没用
	public List<Orders> queryOrdersByStatue(boolean status){
		 
		try {
			sql="select * from orders where ord_status = ?";
     		pre= DBInstance.getConn().prepareStatement(sql);
			 pre.setBoolean(1,status);
			 rs=pre.executeQuery();
//多行的→→→→→→→→	 // ord_id  // ord_totalPrice  // ord_score  // ord_time  // ord_status   // user_id
			 //先new 集合
			  ordersList=new ArrayList<Orders>();
			 while(rs.next()){
				  orders=new Orders();
				 orders.setOrd_id(rs.getString("ord_id"));
				 orders.setOrd_totalPrice(rs.getDouble("ord_totalPrice"));
				 orders.setOrd_time(rs.getTimestamp("ord_time"));
				 orders.setOrd_score(rs.getDouble("ord_score"));
				 orders.setOrd_statue(rs.getBoolean("ord_status"));
				 orders.setOrd_payTime(rs.getTimestamp("ord_payTime"));
				 
				//查询当前订单的用户信息
				 //user_id 在orders 表    user对象存放到orders 里
				 sql1="select * from user where user_id=?";
			     pre1=DBInstance.getConn().prepareStatement(sql1);
			     pre1.setInt(1, rs.getInt("user_id"));
			    rs1= pre1.executeQuery();
			    if(rs1.next()){ //user 对象只有一个    用if
			    	users=new Users();
			    	users.setUsers_id(rs1.getInt("user_id"));
			    	users.setUsers_name(rs1.getString("user_name"));
			    	users.setUsers_sex(rs1.getInt("user_sex"));
			    	users.setUsers_pwd(rs1.getString("user_pwd"));
			    	users.setUsers_phone(rs1.getString("user_phone"));
			    	users.setUsers_score(rs1.getDouble("user_score"));
			    	//封装到orders
			    	orders.setUsers(users);
			    }   
			    
			
			     sql2="select * from ordersItem where ord_id=?";
			     pre2=DBInstance.getConn().prepareStatement(sql2);
			     pre2.setString(1,orders.getOrd_id());
			     ///System.out.println(orders.getOrd_id());
			     rs2=pre2.executeQuery();
			     
			     itemList=new ArrayList<OrdersItem>();
			     while(rs2.next()){  //多条订单项数据  所以 while
			    	 ordersItem = new OrdersItem();
			    	 ordersItem.setItem_id(rs2.getInt("item_id"));
			    	 //ordersItem.setGoods(rs2.getInt("item_id"));
			    	 sql3="select * from goods where goods_id = ?";
			    	 pre3=DBInstance.getConn().prepareStatement(sql3);
			    	 pre3.setInt(1,rs2.getInt("goods_id"));
			    	rs3= pre3.executeQuery();
			    	 while(rs3.next()){
			    		 goods = new Goods();
			    		 goods.setGoods_id(rs3.getInt("goods_id"));
			    		 goods.setGoods_name(rs3.getString("goods_name"));
			    		 goods.setGoods_price(rs3.getDouble("goods_price"));
			    		 goods.setGoods_img(rs3.getString("goods_img"));
			    		 
			    		 category=new Category();
			    		 category.setCat_id(rs3.getInt("cat_id"));
			    		 goods.setCategory(category);
			    		 
			    		 ordersItem.setGoods(goods);
			    		 
			    	 }  //查完释放资源
			    	
			    	  ordersItem.setItem_quantity(rs2.getInt("item_quantity"));
			    	  ordersItem.setItem_singlePrice(rs2.getDouble("item_singlePrice"));
			    	 
			    	  itemList.add(ordersItem);
			     }
			     orders.setOrd_itemList(itemList);
			     
			     			 
				 ordersList.add(orders);
			 }
			 
			 return ordersList;
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}finally{
			DBInstance.close(rs2, pre2,conn2);
			DBInstance.close(rs1, pre1,conn1);
			DBInstance.close(rs3, pre3,conn3);
			DBInstance.close(rs, pre,conn);
		}
		
		
		
	}
	
//  根据用户和支付状态查询用户没支付的订单            //查询的没有支付的
	public List<Orders> queryOrdersByStatueAndUsers(boolean status,Users users){
		
		
		try { 											//最新支付  或者最新
			sql="select * from orders where ord_status = ? and user_id=? ";
     		pre= DBInstance.getConn().prepareStatement(sql);
			 pre.setBoolean(1,status);
			 //System.out.println(users.getUsers_id()+"~~~~~~~~~~~~~~~~~~~");
			 pre.setInt(2,users.getUsers_id());
			 /*pre.setString(3, orderBy);*/
			 rs=pre.executeQuery();
//多行的→→→→→→→→	 // ord_id  // ord_totalPrice  // ord_score  // ord_time  // ord_status   // user_id
			 //先new 集合
			  ordersList=new ArrayList<Orders>();
			 while(rs.next()){
				  orders=new Orders();
				 orders.setOrd_id(rs.getString("ord_id"));
				 orders.setOrd_totalPrice(rs.getDouble("ord_totalPrice"));
				 orders.setOrd_time(rs.getTimestamp("ord_time"));
				 orders.setOrd_score(rs.getDouble("ord_score"));
				 orders.setOrd_statue(rs.getBoolean("ord_status"));
				 orders.setOrd_payTime(rs.getTimestamp("ord_payTime"));
				 
				//查询当前订单的用户信息
				 //user_id 在orders 表    user对象存放到orders 里
				/* 
				 sql1="select * from user where user_id=?";
			     pre1=DBInstance.getConn().prepareStatement(sql1);
			     pre1.setInt(1, rs.getInt("user_id"));
			    rs1= pre1.executeQuery();*/
			    /*if(rs1.next()){ //user 对象只有一个    用if
			    	users=new Users();
			    	users.setUsers_id(rs1.getInt("user_id"));
			    	users.setUsers_name(rs1.getString("user_name"));
			    	users.setUsers_sex(rs1.getInt("user_sex"));
			    	users.setUsers_pwd(rs1.getString("user_pwd"));
			    	users.setUsers_phone(rs1.getString("user_phone"));
			    	users.setUsers_score(rs1.getDouble("user_score"));*/
			    	//封装到orders
			    	orders.setUsers(users);
			    /*} */  
			    
			    //user 表操作完毕     关闭
			   //  DBInstance.close(pre1, rs1);
			     sql2="select * from ordersItem where ord_id=?";
			     pre2=DBInstance.getConn().prepareStatement(sql2);
			     pre2.setString(1,orders.getOrd_id());
			   
			     rs2=pre2.executeQuery();
			     
			     itemList=new ArrayList<OrdersItem>();
			     while(rs2.next()){  //多条订单项数据  所以 while
			    	 ordersItem = new OrdersItem();
			    	 ordersItem.setItem_id(rs2.getInt("item_id"));
			    	 //ordersItem.setGoods(rs2.getInt("item_id"));
			    	 sql3="select * from goods where goods_id = ?";
			    	 pre3=DBInstance.getConn().prepareStatement(sql3);
			    	 pre3.setInt(1,rs2.getInt("goods_id"));
			    	rs3= pre3.executeQuery();
			    	 while(rs3.next()){
			    		 goods = new Goods();
			    		 goods.setGoods_id(rs3.getInt("goods_id"));
			    		 goods.setGoods_name(rs3.getString("goods_name"));
			    		 goods.setGoods_price(rs3.getDouble("goods_price"));
			    		 goods.setGoods_img(rs3.getString("goods_img"));
			    		 
			    		 category=new Category();
			    		 category.setCat_id(rs3.getInt("cat_id"));
			    		 goods.setCategory(category);
			    		 
			    		 ordersItem.setGoods(goods);
			    		 
			    	 }  //查完释放资源
			    	// DBInstance.close(pre3, rs3);
			    	  ordersItem.setItem_quantity(rs2.getInt("item_quantity"));
			    	  ordersItem.setItem_singlePrice(rs2.getDouble("item_singlePrice"));
			    	 
			    	  itemList.add(ordersItem);
			     }
			     orders.setOrd_itemList(itemList);
			     
			     			 
				 ordersList.add(orders);
			 }
			 
			 return ordersList;
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			return null;
		}finally{
			DBInstance.close(rs2, pre2,conn2);
			DBInstance.close(rs1, pre1,conn1);
			DBInstance.close(rs3, pre3,conn3);
			DBInstance.close(rs, pre,conn);
		}
	}



	
	public Orders queryOneOrdersById(String ord_id) {
		
		try {
			sql="select  * from orders where ord_id =  ?  ";
			pre=DBInstance.getConn().prepareStatement(sql);
			
			pre.setString(1, ord_id);
			
			rs=pre.executeQuery();
			
			if(rs.next()){
				orders=new Orders();
				orders.setOrd_id(rs.getString("ord_id"));
				orders.setOrd_totalPrice(rs.getDouble("ord_totalPrice"));
				orders.setOrd_score(rs.getDouble("ord_score"));
				orders.setOrd_time(rs.getTimestamp("ord_time"));
				orders.setOrd_statue(rs.getBoolean("ord_status"));
				orders.setOrd_payTime(rs.getTimestamp("ord_payTime"));
				
				
				sql1="select * from  user where user_id=? ";
				pre1=DBInstance.getConn().prepareStatement(sql1);
			    pre1.setInt(1,rs.getInt("user_id"));
				rs1=pre1.executeQuery();
				if(rs1.next()){   //  一个用户用if
					users = new Users();
					users.setUsers_id(rs1.getInt("user_id"));      //用上一个rs对象里边的user_id
					users.setUsers_name(rs1.getString("user_name"));
					users.setUsers_sex(rs1.getInt("user_sex"));
					users.setUsers_pwd(rs1.getString("user_pwd"));
					users.setUsers_phone(rs1.getString("user_phone"));
					users.setUsers_score(rs1.getDouble("user_score"));
					
					orders.setUsers(users);
					
				}
		
				itemList=new ArrayList<OrdersItem>();
				
				sql2="select  * from ordersItem where ord_id =  ?";
			    pre2=DBInstance.getConn().prepareStatement(sql2);
			    pre2.setString(1,rs.getString("ord_id"));
			    
			    
			    rs2=pre2.executeQuery();
			    
			    while(rs2.next()){
			    	ordersItem = new OrdersItem();
			    	ordersItem.setItem_id(rs2.getInt(1));
			    	
			    	
			    	sql3="select * from goods where goods_id = ?";
			    	pre3=DBInstance.getConn().prepareStatement(sql3);
			    	pre3.setInt(1,rs2.getInt("goods_id"));
			    	rs3=pre3.executeQuery();
			    	while(rs3.next()){
			    		goods=new Goods();
			    		goods.setGoods_id(rs3.getInt("goods_id"));
			    		goods.setGoods_name(rs3.getString("goods_name"));
			    		goods.setGoods_price(rs3.getDouble("goods_price"));
			    		goods.setGoods_img(rs3.getString("goods_img"));
			    		category=new Category();
			    		category.setCat_id(rs3.getInt("cat_id"));
			    		goods.setCategory(category);
			    	}
			    	ordersItem.setGoods(goods);  //商品信息 添加到订单项里边去
			    	ordersItem.setItem_quantity(rs2.getInt("item_quantity"));
			    	ordersItem.setItem_singlePrice(rs2.getDouble("item_singlePrice"));
			    	ordersItem.setOrd_id(rs2.getString("ord_id"));
			    	
			    	  itemList.add(ordersItem);  //把订单项存放到订单项集合里边去
			    }
			  
			  
				  //应该放下边也行  节省资源?
			    orders.setOrd_itemList(itemList);
			}
			
			
			return orders;
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			return null;
		}finally{
			DBInstance.close(rs2, pre2,conn2);
			DBInstance.close(rs1, pre1,conn1);
			DBInstance.close(rs3, pre3,conn3);
			DBInstance.close(rs, pre,conn);
		}
		
	}



	//  修改订单状态  产生积分给用户    状态改成true  积分也加了 存放到Orders里边  user_score添加
	//前台把积分处理一下就好   或者 实体类里边???
	public Orders payOrders(Orders orders, boolean status,double score) {
		 
		//应该在判断一下  传过来的订单状态是不是false  如果是false  再执行↓↓↓↓↓↓
		try {
			sql="update orders set ord_status=? , ord_payTime=now()  where ord_id=?";
			pre=DBInstance.getConn().prepareStatement(sql);
			pre.setBoolean(1,status);
			
			pre.setString(2,orders.getOrd_id());
			int i=pre.executeUpdate();
			if(i>0){   
				orders.setOrd_statue(status);  //修改当前接收的orders的订单状态
				//orders.setOrd_score(0);   //当前订单可以产生的积分数量  应该不用修改
			
								
				sql1="update user set user_score = ? where user_id=?";
				pre1=DBInstance.getConn().prepareStatement(sql1);
				pre1.setDouble(1,score);  //修改积分  积分是订单总价  
				
				pre1.setInt(2,orders.getUsers().getUsers_id());
			     
				num1=pre1.executeUpdate();
				
				if(num1>0){    //修改 重新给orders里边的users_score
					users=orders.getUsers();
					users.setUsers_score(score); // 改变返回的orders里边的 用户积分
					orders.setUsers(users);
				}
				
				 
			}
		 	
			return orders;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			DBInstance.close(rs2, pre2,conn2);
			DBInstance.close(rs1, pre1,conn1);
			DBInstance.close(rs3, pre3,conn3);
			DBInstance.close(rs, pre,conn);
		}
		
		
		
	
	}



	  //查询用户所有已经支付的订单  根据用户id 
	  public List<Orders> queryOrdersByStatueAndUsersIsPay(int users_id) {
		
		  
		  
		return null;
	}



	//根据订单创建时间 给用户的订单进行排序   
	public List<Orders> queryOrdersByUserAndOrderByOrd_status(boolean status,Users users,int i) {
		
		try { 		 if(i==1){
			sql="select * from orders where ord_status = ? and user_id=? order by ord_time desc";
					
		     } else {  // int 类型默认是  0    所以不用比较     而且   应该用 下拉列表 或者  单选按钮才合理
		    	 
		    	 sql="select * from orders where ord_status = ? and user_id=? order by ord_time ASC";
		     }
			
			
     		pre= DBInstance.getConn().prepareStatement(sql);
			 pre.setBoolean(1,status);
			 //System.out.println(users.getUsers_id()+"~~~~~~~~~~~~~~~~~~~");
			 pre.setInt(2,users.getUsers_id());
			 /*pre.setString(3, orderBy);*/
			 rs=pre.executeQuery();
//多行的→→→→→→→→	 // ord_id  // ord_totalPrice  // ord_score  // ord_time  // ord_status   // user_id
			 //先new 集合
			  ordersList=new ArrayList<Orders>();
			 while(rs.next()){
				  orders=new Orders();
				 orders.setOrd_id(rs.getString("ord_id"));
				 orders.setOrd_totalPrice(rs.getDouble("ord_totalPrice"));
				 orders.setOrd_time(rs.getTimestamp("ord_time"));
				 orders.setOrd_score(rs.getDouble("ord_score"));
				 orders.setOrd_statue(rs.getBoolean("ord_status"));
				 orders.setOrd_payTime(rs.getTimestamp("ord_payTime"));
				 
				 
		         orders.setUsers(users);   //不用查询直接传递users
		         
			     sql2="select * from ordersItem where ord_id=?";
			     pre2=DBInstance.getConn().prepareStatement(sql2);
			     pre2.setString(1,orders.getOrd_id());
			   
			     rs2=pre2.executeQuery();
			     
			     itemList=new ArrayList<OrdersItem>();
			     while(rs2.next()){  //多条订单项数据  所以 while
			    	 ordersItem = new OrdersItem();
			    	 ordersItem.setItem_id(rs2.getInt("item_id"));
			    	 //ordersItem.setGoods(rs2.getInt("item_id"));
			    	 sql3="select * from goods where goods_id = ?";
			    	 pre3=DBInstance.getConn().prepareStatement(sql3);
			    	 pre3.setInt(1,rs2.getInt("goods_id"));
			    	rs3= pre3.executeQuery();
			    	
			    	 while(rs3.next()){
			    		 goods = new Goods();
			    		 goods.setGoods_id(rs3.getInt("goods_id"));
			    		 goods.setGoods_name(rs3.getString("goods_name"));
			    		 goods.setGoods_price(rs3.getDouble("goods_price"));
			    		 goods.setGoods_img(rs3.getString("goods_img"));
			    		 
			    		 category=new Category();
			    		 category.setCat_id(rs3.getInt("cat_id"));
			    		 goods.setCategory(category);
			    		 
			    		 ordersItem.setGoods(goods);
			    		 
			    	 }  
			    	  ordersItem.setItem_quantity(rs2.getInt("item_quantity"));
			    	  ordersItem.setItem_singlePrice(rs2.getDouble("item_singlePrice"));
			    	 
			    	  itemList.add(ordersItem);
			     }
			     orders.setOrd_itemList(itemList);
			     
			     			 
				 ordersList.add(orders);
			 }
			 
			 return ordersList;
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			return null;
		}finally{
			DBInstance.close(rs2, pre2,conn2);
			DBInstance.close(rs1, pre1,conn1);
			DBInstance.close(rs3, pre3,conn3);
			DBInstance.close(rs, pre,conn);
		}
	}
		

}
