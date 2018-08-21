package com.szy.common.base;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseAction {
	
	
	/**
	 * 把对象转换成json字符串 ,写给页面
	 * @author fanshuang
	 * @param response
	 * @param obj
	 */
	public void writeJson(HttpServletResponse response,Object obj){
		
			ObjectMapper objectMapper = new ObjectMapper();
			String json=null;
		try {
			json = objectMapper.writeValueAsString(obj);
			System.err.println("——————————————>>>>json字符串是---> "+json);
			write(response,json);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 把字符串直接写给页面
	 * @author fanshuang
	 * @param response
	 * @param str
	 * 
	 */
	public void write(HttpServletResponse response,String str) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		try {
			response.getWriter().write(str);
		  } catch (IOException e) {
			  	e.printStackTrace();
		       }
	}
	
	
	
	
	
}
