//package com.szy.common.converter;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
//@Component(value="dateConverter")
//public class DateConverter implements Converter<String, Date> {
//
//
//	@Override
//	public Date convert(String strDate) {
//		SimpleDateFormat simpleDateFormat = new  SimpleDateFormat("yyyy-MM-dd");
//		
//		try {
//			return simpleDateFormat.parse(strDate);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
//
//}
