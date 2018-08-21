package com.web.servlet.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.factory.DaoFactory;
import com.web.util.DBInstance;
import com.web.vo.Car;
import com.web.vo.CarItem;
import com.web.vo.Goods;
import com.web.vo.Orders;
import com.web.vo.OrdersItem;
import com.web.vo.Users;

public class OrdersServlet extends HttpServlet {
     
	String path=null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		
		String action=request.getParameter("action");
		 
		   //把购物车信息添加到未支付订单    carList.jsp条转过来的
		if(action.equals("addOrders")){
			addOrders(request,response);
			
			//暂时没用
		}else if (action.equals("queryOrdersByStatue")){
			queryOrdersByStatue(request,response);
			//System.out.println("跳转成功~~~");
		}
		    //  根据用户和支付状态查询查询用户没支付的订单 
		else if (action.equals("queryOrdersByStatueAndUsers")){
			queryOrdersByStatueAndUsers(request,response);
			
			//查询用户所有已经支付的订单  根据用户id       gerenxinxi.jsp条转过来的
		}else if (action.equals("queryOrdersByStatueAndUsersIsPay")){
			queryOrdersByStatueAndUsersIsPay(request,response);
			
			//显示用户单个订单详情  
		}else if (action.equals("queryOneOrdersById")){
			queryOneOrdersById(request,response);
			
			//用户支付   修改状态产生积分    dingdantijiao.jsp 界面 条转过来的
		}else if("payOrders".equals(action)){
			payOrders(request,response);
		}
	//  根据用户和支付状态查询单个用户没支付的订单 
		else if("queryOneOrdersByOrd_idAndOrd_statueIsTrue".equals(action)){
			queryOneOrdersByOrd_idAndOrd_statueIsTrue(request,response);
			
			
			//根据订单创建时间 给用户的订单进行排序        gerenxinxi_daifukuandingdanliebiao.jsp
		}else if("queryOrdersByUserAndOrderByOrd_status".equals(action)){
			queryOrdersByUserAndOrderByOrd_status(request,response);
			
		}  
		  //查询用户已经支付的  并根据所传状态排序
		else if("queryOrdersByUsersIsPayAndOrderByOrd_status".equals(action)){
			queryOrdersByUsersIsPayAndOrderByOrd_status(request,response);
		}
		
		
		  
		
	}        
	
	  private void queryOrdersByUsersIsPayAndOrderByOrd_status(	HttpServletRequest request, HttpServletResponse response) {
		 
		  int i=Integer.parseInt(request.getParameter("orderBy"));
			//int 类型默认是  0    所以不用比较     而且   应该用 下拉列表 或者  单选按钮才合理
			HttpSession session= request.getSession();
			Users users=(Users)session.getAttribute("users");
		
			Users users1=DaoFactory.getUsersDao().queryByUsers_phone(users.getUsers_phone());
			boolean status=true;
			
			List<Orders> ordersList= DaoFactory.getOrdersDao().queryOrdersByUserAndOrderByOrd_status(status,users1, i);
			
			   session.setAttribute("ordersList",ordersList);
			
				   
				 path="client/gerenxinxi_yifukuandingdanliebiao.jsp";
				 try {
					response.sendRedirect(path);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	private void queryOrdersByUserAndOrderByOrd_status(HttpServletRequest request, HttpServletResponse response) {
		int i=Integer.parseInt(request.getParameter("orderBy"));
		//int 类型默认是  0    所以不用比较     而且   应该用 下拉列表 或者  单选按钮才合理
		HttpSession session= request.getSession();
		Users users=(Users)session.getAttribute("users");
	
		Users users1=DaoFactory.getUsersDao().queryByUsers_phone(users.getUsers_phone());
		boolean status=false;
		
		List<Orders> ordersList= DaoFactory.getOrdersDao().queryOrdersByUserAndOrderByOrd_status(status,users1, i);
		
		   session.setAttribute("ordersList",ordersList);
		
			   
			 path="client/gerenxinxi_daifukuandingdanliebiao.jsp";
			 try {
				response.sendRedirect(path);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
}

	// 查询一个用户已经支付了的订单
	private void queryOneOrdersByOrd_idAndOrd_statueIsTrue(	HttpServletRequest request, HttpServletResponse response) {
		

		 String ord_id=request.getParameter("ord_id");
		  HttpSession session=request.getSession();
		 Users users= (Users) session.getAttribute("users");
		 //只为了获取一个完整的用户信息
		 Users users1=DaoFactory.getUsersDao().queryByUsers_phone(users.getUsers_phone());
		 
		 session.setAttribute("users",users1);
		 
		Orders orders= DaoFactory.getOrdersDao().queryOneOrdersById(ord_id);
		
		 
		session.setAttribute("orders",orders); 
		path="client/gerenxinxi_yifukuandingdan.jsp";
		/* path="Test.jsp";*/
		try {
			response.sendRedirect(path);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	//查询用户所有已经支付的订单  根据用户id 
	  private void queryOrdersByStatueAndUsersIsPay(HttpServletRequest request,HttpServletResponse response) {
		  
		  HttpSession session=request.getSession();
		 Users users= (Users) session.getAttribute("users");
	
		 users= DaoFactory.getUsersDao().queryByUsers_phone(users.getUsers_phone());
	
		 List<Orders> ordersList=  DaoFactory.getOrdersDao().queryOrdersByStatueAndUsers(true, users);
	
		 session.setAttribute("ordersList",ordersList);
		 path="client/gerenxinxi_yifukuandingdanliebiao.jsp";
		
		 try {
			response.sendRedirect(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
                    //修改订单状态  产生积分给用户
	private void payOrders(HttpServletRequest request,HttpServletResponse response) {HttpSession session=request.getSession();
		 
	    Orders orders1=(Orders) session.getAttribute("orders");
		double ord_totalPrice=Double.parseDouble(request.getParameter("ord_totalPrice"));
		//接收传过来的订单总价
		  orders1.setOrd_totalPrice(ord_totalPrice);  //重新传给orders 
		  
		  
		  
		  
		  boolean status= orders1.isOrd_statue();
		  status=true;
		 /* System.out.println(status);*/
		  double score=orders1.getOrd_totalPrice();
		  //System.out.println(score);
		  Orders orders=DaoFactory.getOrdersDao().payOrders(orders1, status,score);
		  
		  System.out.println("新的orders是::::"+orders);
		  
		 //消费了 多少积分  显示  应该定义一个积分表的``

		   
			 path="client/gerenxinxi_yifukuandingdan.jsp";
			 try {
				response.sendRedirect(path);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  

		
	}

	private void queryOneOrdersById(HttpServletRequest request,HttpServletResponse response) {
		    
		
		 String ord_id=request.getParameter("ord_id");
		  HttpSession session=request.getSession();
		 Users users= (Users) session.getAttribute("users");
		 //只为了获取一个完整的用户信息
		 Users users1=DaoFactory.getUsersDao().queryByUsers_phone(users.getUsers_phone());
		 
		 session.setAttribute("users",users1);
		 
		Orders orders= DaoFactory.getOrdersDao().queryOneOrdersById(ord_id);
		// System.out.println(users+"--------");
		session.setAttribute("orders",orders); 
		/*path="client/gerenxinxi_dingdanxiangxiye.jsp";*/       //代付款订单详情页  不往这里跳
		path="client/dingdantijiao.jsp";
		
		try {
			response.sendRedirect(path);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		// System.out.println(orders+"!!!!!!!!!!!!!!!!");
		     //session.getAttribute("");
		
		  
		  
		  
		  
		  
		     
	}

	private void queryOrdersByStatueAndUsers(HttpServletRequest request,HttpServletResponse response) {
		
		   HttpSession session=request.getSession();
		   Users users1=(Users) session.getAttribute("users");
		  Users users=DaoFactory.getUsersDao().queryByUsers_phone(users1.getUsers_phone());
		
		   List<Orders> ordersList= DaoFactory.getOrdersDao().queryOrdersByStatueAndUsers(false, users);
				   session.setAttribute("ordersList",ordersList);
				  // System.out.println(order);
				/*   for(Orders  orders:ordersList){
					   System.out.println(orders.getOrd_time());
				   }*/
		   
		 path="client/gerenxinxi_daifukuandingdanliebiao.jsp";
		 try {
			response.sendRedirect(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//查询还没支付的订单
	private void queryOrdersByStatue(HttpServletRequest request,HttpServletResponse response) {
		   
		List<Orders>ordersList=	DaoFactory.getOrdersDao().queryOrdersByStatue(false);
		   /*for(Orders orders:ordersList){
			   System.out.println(orders.toString());
		   }*/
		HttpSession  session=request.getSession();
		session.setAttribute("ordersList", ordersList);
		path="client/";
	}


	private void addOrders(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession();	
		Car car=(Car) session.getAttribute("car");
		Users users = (Users) session.getAttribute("users");
		if(users==null){
			  //  用户没登录   跳转登录界面
			  // 购物车信息已经存放到session对象,  
		try {
			response.sendRedirect("client/login.jsp");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}else if(users!=null){
			  //先查user的id  或者根据phone  查询所有信息
	    System.out.println(users.getUsers_phone()+"用户登陆成功");
			Users users1=DaoFactory.getUsersDao().queryByUsers_phone(users.getUsers_phone());
			
		//System.out.println(users);
			
			
			
			//存数据库
			 Orders orders=new Orders();
			 OrdersItem ordersItem=null;
			 List<OrdersItem> itemList= new ArrayList<OrdersItem>();
			
			//System.out.println(orders.getOrd_id());
			 //orders.setOrd_id(new Date().toString());
			// System.out.println(orders.getOrd_id());
			
			
			
		/*	private int item_id ;                  // 订单项  id
			private Goods goods ;       			 //订单项里边的商品信息
			private int item_quantity ;    			 // 订单项的数量
			private double item_singlePrice ;  		  //单品总价
			private String ord_id ;           	 	  //订单项对应的订单类的id
*/			orders.setOrd_id(java.util.UUID.randomUUID().toString());
			Set<Entry<Integer, CarItem>>  set=car.getMap().entrySet();
			  for(Entry<Integer,CarItem> entry: set){
				  CarItem carItem = entry.getValue() ;
				  ordersItem = new OrdersItem();
				  
				  ordersItem.setGoods(carItem.getGoods());
				  ordersItem.setItem_quantity(carItem.getQuantity());
				  ordersItem.setItem_singlePrice(carItem.getSinglePrice());
				  ordersItem.setOrd_id(orders.getOrd_id());
				  
				  itemList.add(ordersItem);
			  }
			    orders.setOrd_itemList(itemList);                //订单项集合
			    orders.setOrd_totalPrice(car.getTotalPrice());  //订单的总金额
			    orders.setOrd_score(0);             //  支付以后才产生积分
			                                       //这是添加未付款订单  所以积分一直是0
			    
			    orders.setOrd_statue(false);                   //没有支付
			    orders.setUsers(users1);                     // 谁的订单
			    
			     //这里肯定得用一个方法
			   int num= DaoFactory.getOrdersDao().addOrders(orders) ;
			   int num1=DaoFactory.getOrdersDao().addOrdersItem(orders);
			   if(num>0&&num1>0){
				   System.out.println("所有订单项和订单信息添加成功");
			   }
			
			System.out.println(num+"行订单信息被添加++++");
			System.out.println(num1+"行订单项信息被添加----");
			/*path="ordersServlet?action=queryOrdersByStatueAndUsers";*/
			session.setAttribute("orders",orders);
			path="client/dingdantijiao.jsp";
			
			try {
				response.sendRedirect(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		/*	private String ord_id ;
		    private List<OrdersItem> ord_itemList ;//订单项
			private double ord_totalPrice ; 		//订单总价
			private double ord_score ;				 //订单可以生成的积分    和 订单总价一样
		    private Date ord_time ;     			 //订单生成时间
			private boolean ord_statue ; 			  //订单是否结算 
			private Users users ;  					 //哪个人的订单?
*/		
		    
			session.setAttribute("users",users1);
			
			session.removeAttribute("car");   //支付完成   按理说就只需要把支付的商品删除    这里全部删除
		
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
					doGet(request, response);
	}

}
