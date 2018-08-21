package com.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBInstance {

	/* static Connection conn=null;
	 static PreparedStatement pre=null;
	 static ResultSet rs=null;*/
	 
	
	 public static Connection getConn(){
		 Connection conn=null;
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
			System.out.println("数据库驱动加载失败");
		}
		 try {
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mi_fan","root","123456");
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		 
		return conn;
	 }
	 
	   public static void close(ResultSet rs,PreparedStatement pre,Connection conn){
		   
		    if(rs!=null){
		    	
		    	try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("结果集关闭异常");
				}
		    } if(pre!=null){
		    	try {
					pre.close();
				
				} catch (SQLException e) {
					
					e.printStackTrace();
					System.out.println("pre关闭异常");
				}
		    	
		    	
		    }if(conn!=null){
		    	
		    	try {
					conn.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
					System.out.println("连接关闭异常");
				}
		    }
		   
		   
	   }
	   
	     public static void close(PreparedStatement pre,Connection conn){
	    	  if(pre!=null){
	    		  try {
					pre.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
					System.out.println("pre关闭异常");
				}
	    	  }
	    	  if(conn!=null){
	    		  try {
					conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
					System.out.println("连接关闭异常");
				}
	    	  }
	    	 
	     }
	    
}
