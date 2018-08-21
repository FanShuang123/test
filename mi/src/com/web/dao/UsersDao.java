package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.web.idao.IUsersDao;
import com.web.util.DBInstance;
import com.web.vo.Category;
import com.web.vo.Goods;
import com.web.vo.Users;

public class UsersDao implements IUsersDao{

	private Connection conn=null;
	   private PreparedStatement pre=null;
	   private ResultSet rs=null;
	   private Category category=null;
	   private Goods goods=null;
	   String sql=null;
	   Users users=null;
	
	//用户注册
	public int addUsers(Users users) {
	    //String sql="insert into userInfo (user_name,user_pwd,user_sex,user_card,user_phone)values (?,?,?,?,?)";
		/*System.out.println(users.getUsers_pwd());
		System.out.println("userPhone+"+users.getUsers_phone());*/
		try {
			sql="insert into user (user_pwd,user_phone) values(?,?)";
			pre=DBInstance.getConn().prepareStatement(sql);
			pre.setString(1,users.getUsers_pwd());
			pre.setString(2,users.getUsers_phone());
			
			int num=pre.executeUpdate();
			return num;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return 0;
		}
		
	}

	
	public boolean login(Users user) {
		 
			try {sql="select * from user where user_phone=? and user_pwd=?";
				pre=DBInstance.getConn().prepareStatement(sql);
				pre.setString(1,user.getUsers_phone());
				  pre.setString(2,user.getUsers_pwd());
				  rs=pre.executeQuery();
				  if(rs.next()){
					  
					  return true;
				  }else {
					  return false;
				  }
				  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}finally{
				DBInstance.close(rs, pre, conn);
				
			}
		
			
	}
	//根据users_phone  查询 users
	public Users queryByUsers_phone(String users_phone) {
		// TODO Auto-generated method stub
		
		try {
			sql="select * from user where user_phone=? ";
			pre=DBInstance.getConn().prepareStatement(sql);
			pre.setString(1,users_phone);
			 
			  rs=pre.executeQuery();
			  
			  if(rs.next()){
				  users=new Users();
				  users.setUsers_id(rs.getInt("user_id"));
				  users.setUsers_name(rs.getString(2));
				  users.setUsers_sex(rs.getInt(3));
				   users.setUsers_pwd(rs.getString("user_pwd"));
				  users.setUsers_phone(rs.getString("user_phone"));
				  users.setUsers_score(rs.getDouble(6));
				  
				  
				  
			  }return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}


	@Override
	public List<Users> showAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users queryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modUser(Users user) {
		// TODO Auto-generated method stub
		return 0;
	}



	
}
