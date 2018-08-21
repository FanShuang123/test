package com.szy.huike.systemset.pojo;

import java.math.BigDecimal;

public class EmployeeCategory {
	
	
	private Integer catId;  // 主键
	
	private String catName;   //类型名称

	private String pushType ;   //提成方式
	
	private BigDecimal catQuota;// 类别提成额度
	
	private String catNote;  //类别备注信息

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getPushType() {
		return pushType;
	}

	public void setPushType(String pushType) {
		this.pushType = pushType;
	}

	public BigDecimal getCatQuota() {
		return catQuota;
	}

	public void setCatQuota(BigDecimal catQuota) {
		this.catQuota = catQuota;
	}

	public String getCatNote() {
		return catNote;
	}

	public void setCatNote(String catNote) {
		this.catNote = catNote;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catId == null) ? 0 : catId.hashCode());
		result = prime * result + ((catName == null) ? 0 : catName.hashCode());
		result = prime * result + ((catNote == null) ? 0 : catNote.hashCode());
		result = prime * result + ((catQuota == null) ? 0 : catQuota.hashCode());
		result = prime * result + ((pushType == null) ? 0 : pushType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeCategory other = (EmployeeCategory) obj;
		if (catId == null) {
			if (other.catId != null)
				return false;
		} else if (!catId.equals(other.catId))
			return false;
		if (catName == null) {
			if (other.catName != null)
				return false;
		} else if (!catName.equals(other.catName))
			return false;
		if (catNote == null) {
			if (other.catNote != null)
				return false;
		} else if (!catNote.equals(other.catNote))
			return false;
		if (catQuota == null) {
			if (other.catQuota != null)
				return false;
		} else if (!catQuota.equals(other.catQuota))
			return false;
		if (pushType == null) {
			if (other.pushType != null)
				return false;
		} else if (!pushType.equals(other.pushType))
			return false;
		return true;
	}

	public EmployeeCategory() {}
	
	

}
