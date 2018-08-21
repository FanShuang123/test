package com.web.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainTest {
	public static void main(String[] args) {
		
		
		
		/*SimpleDateFormat sim=new	SimpleDateFormat() ;
		Date date=new Date();
  System.out.println(date);
		System.out.println();*/
		String c1="C:\\Users\\Administrator\\Desktop\\5BADCC949D99151326F7641AEB0635E3.png";
		//String c1="C:\Users\Administrator\Desktop\5BADCC949D99151326F7641AEB0635E3.png";
		
		String w=c1.substring(c1.lastIndexOf("\\")+1)	;
		System.out.println(w);
		
		
		
	}

}
