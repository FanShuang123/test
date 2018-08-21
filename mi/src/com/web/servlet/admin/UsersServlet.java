package com.web.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.factory.DaoFactory;
import com.web.util.DM5;
import com.web.vo.Users;

public class UsersServlet extends HttpServlet {
	 Users users = null;
	String path=null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*System.out.println(request.getParameter("users_name"));
		System.out.println(request.getParameter("users_pwd"));*/
		String action = request.getParameter("action");
	 if(action.equals("addUsers")){
		 addUsers(request, response);
		 //用户登录
	 }else if (action.equals("login")){
		 login(request,response);
		 //用户退出
	 }else if("usersExit".equals(action)){
		 usersExit(request,response);
		 
	  }
	 
	    //判断当前用户是否登陆  
	 else if(action.equals("isLogin")){
		 
		 isLogin(request,response);
		 
	 }
	 

	  // request.getRequestDispatcher(path).forward(request,response);
	}
              
	private void isLogin(HttpServletRequest request,HttpServletResponse response) {
		
		Users users=(Users) request.getSession().getAttribute("users");
		if(users==null){
			
			path="client/login.jsp";
			
		
		}else {
			
			path="client/gerenxinxi.jsp";
		}
		try {
			response.sendRedirect(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void usersExit(HttpServletRequest request,HttpServletResponse response) {
		
		HttpSession session=request.getSession();
		//System.out.println(users);
		Users users=(Users) session.getAttribute("users");
		session.removeAttribute("users");
		path="client/login.jsp";
		
	//	System.out.println(users);
		try {
			response.sendRedirect(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void login(HttpServletRequest request,HttpServletResponse response) throws ServletException {
		String users_phone=request.getParameter("users_phone");
		String users_pwd=request.getParameter("users_pwd");
		users=new Users();
		  users.setUsers_phone(users_phone);
		 
		  users.setUsers_pwd(DM5.MD5(users_pwd));
		  //
		   boolean f=DaoFactory.getUsersDao().login(users);
		
		    if(f){
		    	path="client/gerenxinxi.jsp";
		    	try {
		    		//request.setAttribute("users_phone",users_phone); //传递用户名到欢迎界面
		    		HttpSession  session=request.getSession();
		    		session.setAttribute("users", users);
		    		//System.out.println(users);
					response.sendRedirect(path);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    }else{
		    	
		    	String msg=null;
		    	System.out.println("密码错误");
		    	request.setAttribute("密码错误,请重新输入","");
		    	path="client/msg.jsp";
		    	try {
					request.getRequestDispatcher(path).forward(request, response);
				} catch (ServletException e) {
						e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    }
	}

	private void addUsers(HttpServletRequest request,HttpServletResponse response) {
		String users_phone=request.getParameter("users_phone");
		String users_pwd=request.getParameter("users_pwd");
		
		  users=new Users();
		  users.setUsers_phone(users_phone);
		 
		  users.setUsers_pwd(DM5.MD5(users_pwd));
		  
		  //System.out.println(users.getUsers_pwd());  //测试
		  
		int num=  DaoFactory.getUsersDao().addUsers(users);
		
		  if(num>0){
			   //直接登录
			  path="client/login.jsp";
			  try {
				response.sendRedirect(path);  //跳转到登录界面
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }else {
			  System.out.println("注册失败");
			  //path="client/gerenxinxi.jsp";
		  }
		                                                                   
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

}
