package com.web.vo;

public class Category {
 private int cat_id;    //类别id
 private String cat_name;  //类别名称
 private String cat_desc;   //类别描述
 
 
 
public Category() {
	
}
@Override
public String toString() {
	return "Category [cat_id=" + cat_id + ", cat_name=" + cat_name
			+ ", cat_desc=" + cat_desc + "]";
}
public int getCat_id() {
	return cat_id;
}
public void setCat_id(int cat_id) {
	this.cat_id = cat_id;
}
public String getCat_name() {
	return cat_name;
}
public void setCat_name(String cat_name) {
	this.cat_name = cat_name;
}
public String getCat_desc() {
	return cat_desc;
}
public void setCat_desc(String cat_desc) {
	this.cat_desc = cat_desc;
}
 
 
 
}
