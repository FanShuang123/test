package com.web.servlet.client;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.factory.DaoFactory;
import com.web.vo.Car;
import com.web.vo.CarItem;
import com.web.vo.Goods;

public class CarServlet extends HttpServlet {
	String path=null;
	public static int num=1;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    
		String action=request.getParameter("action");
		//System.out.println(action);
		
		 //  添加到购物车
		if(action.equals("addCar")){
		addCar(request,response);
		
		 
		}//减少购物车项    carList.jsp  跳转过来的
		else if(action.equals("redCar")){
			
			redCar(request,response);
		}     //删除购物车  , 并不是删除所有  不是清空
		
		else if("delCar".equals(action)){
			delCar(request,response);
		}else if("clearCar".equals(action)){
			clearCar(request,response);
		}
		
		
		
		
	}
	
	 
		private void clearCar(HttpServletRequest request,HttpServletResponse response) {
			
			
					
				
	}
		private void delCar(HttpServletRequest request, HttpServletResponse response) {
			
			
			int goods_id=Integer.parseInt(request.getParameter("goods_id"));
			//声明session对象
			HttpSession session = request.getSession() ;
			
			//获取购物车
			Car car = (Car) session.getAttribute("car") ; 
			 Map<Integer, CarItem>  map=car.getMap();
			 System.out.println("旧的"+car);
			 if(map==null){
				 
				 System.out.println("购物车没了");
				 
			 }else {
				 Set<Entry<Integer, CarItem>> set=    map.entrySet();
				 		for( Entry<Integer, CarItem> carItem:set){
				 			
				 			System.out.println(carItem);
				 		}
			 }
			
			
	
			
	
	
		
	}
private void redCar(HttpServletRequest request, HttpServletResponse response) {
	
		//接收当前商品编号
		int goods_id=Integer.parseInt(request.getParameter("goods_id"));
		//声明session对象
		HttpSession session = request.getSession() ;
		
		//获取购物车
		Car car = (Car) session.getAttribute("car") ;
     
		 Map<Integer, CarItem>  map=car.getMap();
		 CarItem carItem=  map.get(goods_id);
		  // 只用修改数量
		 if(carItem.getQuantity()>=1){
			 // 数量为正数
			 carItem.setQuantity(carItem.getQuantity()-1);
		 }else {
		        //如果是负数           //
			 session.setAttribute("msg"," <script type='text/javascript'>  alert('数量不能为负数');  </script>");
			  //弹框显示不能为负数  仿佛没起作用、、  
		 }
		 
		 
		 
		 path = "client/carList.jsp" ;
		 try {
			response.sendRedirect(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

		
	
	//
	private void addCar(HttpServletRequest request, HttpServletResponse response) {
		// 接收当前商品编号
		int goods_id =Integer.parseInt(request.getParameter("goods_id"));  
		
		//根据编号查询商品信息 
		Goods goods=DaoFactory.getGoodsDao().queryById(goods_id);
		  //声明session对象
		HttpSession session = request.getSession() ;
		session.setAttribute("num",num);
		
		//获取购物车
		Car car = (Car) session.getAttribute("car") ;
		if(car==null){
			car=new Car();
		}
		CarItem  carItem=car.getMap().get(goods_id);
		if(carItem==null){
			carItem=new CarItem();
			carItem.setGoods(goods);
			carItem.setQuantity(1);
			
		}else{
			      //如果存在,那就数量+1
			carItem.setQuantity(carItem.getQuantity()+1);
		}
		
		car.getMap().put(goods_id, carItem) ;
		car.setMap(car.getMap());
		
		///System.out.println(car);
		//System.out.println("物品名称::"+carItem.getGoods().getGoods_name());
		//System.out.println("价格::"+carItem.getGoods().getGoods_price());
		  /*carItem  ↓ ↓ ↓ ↓ ↓ ↓
		   * 商品信息
				private Goods goods ;
			购买数量
				private int quantity ;
			单品总价
				private double singlePrice ;
				*/
		
	  //把 car()
		session.setAttribute("car", car); 
		 path = "client/carList.jsp";
		try {
			response.sendRedirect(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	doGet(request, response);
	
	}

}
