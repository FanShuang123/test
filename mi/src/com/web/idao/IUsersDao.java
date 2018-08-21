package com.web.idao;

import java.util.List;

import com.web.vo.Users;

public interface IUsersDao {
	
	 //注册   register
	 public  int addUsers(Users users);
	 
	 //用户登录界面
	public boolean login(Users user);
	
	//用户全展示
	public List<Users> showAllUsers();
	 
	 // 用户单个查询进行修改
	public Users queryById(int id);
	
		//修改用户信息
	public int modUser(Users users) ;
	
	////根据users_phone  查询 users
	public Users queryByUsers_phone(String users_phone);
	 

}
