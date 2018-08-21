package com.web.vo;

public class Users {
	
	 private int users_id;
	 private String users_name;
	 private String users_pwd;
	 private int users_sex;    //( 0  是女,1 是男)
	 private String users_phone; // 电话 xxx-xxxx-xxxx
	 private double users_score;   //用户积分
	 
	public Users() {
		
	}
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	public String getUsers_name() {
		return users_name;
	}
	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}
	public String getUsers_pwd() {
		return users_pwd;
	}
	public void setUsers_pwd(String users_pwd) {
		this.users_pwd = users_pwd;
	}
	public int getUsers_sex() {
		return users_sex;
	}
	public void setUsers_sex(int users_sex) {
		this.users_sex = users_sex;
	}
	public String getUsers_phone() {
		return users_phone;
	}
	public void setUsers_phone(String users_phone) {
		this.users_phone = users_phone;
	}
	public double getUsers_score() {
		return users_score;
	}
	public void setUsers_score(double users_score) {
		this.users_score = users_score;
	}
	@Override
	public String toString() {
		return "Users [users_id=" + users_id + ", users_name=" + users_name
				+ ", users_pwd=" + users_pwd + ", users_sex=" + users_sex
				+ ", users_phone=" + users_phone + ", users_score="
				+ users_score + "]";
	}

	 
	

}
