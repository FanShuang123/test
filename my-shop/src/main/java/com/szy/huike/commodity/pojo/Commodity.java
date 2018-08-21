package com.szy.huike.commodity.pojo;

import java.math.BigDecimal;

import com.szy.huike.repertory.pojo.Repertory;

public class Commodity {
	
	private Integer comId;   //商品主键id
	
	private Integer comNo;   //商品编号
	
	private String comName;   //商品名称
	
	private String comUnit;    //商品单位   <个,件 ,捆 等>
	
	private BigDecimal comInPrice;    //进价
	
	private BigDecimal comOutPrice;    //售价
	
	private Category category;   //商品类别
	
	private String comBrevityCode ;  //商品简码

	private Repertory repertory;   //库存表
	
	
	
	
}
