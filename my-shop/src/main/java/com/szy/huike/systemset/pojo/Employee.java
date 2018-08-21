package com.szy.huike.systemset.pojo;

public class Employee {
	
	private Integer empId;  //标识
	private String empName;  //姓名
	private String empTel;
	private String empAddr;  //地址
	private String empNote;    //备注 
	private EmployeeCategory category;   //对应的类别
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((empAddr == null) ? 0 : empAddr.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((empNote == null) ? 0 : empNote.hashCode());
		result = prime * result + ((empTel == null) ? 0 : empTel.hashCode());
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
		Employee other = (Employee) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (empAddr == null) {
			if (other.empAddr != null)
				return false;
		} else if (!empAddr.equals(other.empAddr))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (empNote == null) {
			if (other.empNote != null)
				return false;
		} else if (!empNote.equals(other.empNote))
			return false;
		if (empTel == null) {
			if (other.empTel != null)
				return false;
		} else if (!empTel.equals(other.empTel))
			return false;
		return true;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpTel() {
		return empTel;
	}
	public void setEmpTel(String empTel) {
		this.empTel = empTel;
	}
	public String getEmpAddr() {
		return empAddr;
	}
	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}
	public String getEmpNote() {
		return empNote;
	}
	public void setEmpNote(String empNote) {
		this.empNote = empNote;
	}
	public EmployeeCategory getCategory() {
		return category;
	}
	public void setCategory(EmployeeCategory category) {
		this.category = category;
	}
	public Employee() {
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empTel=" + empTel + ", empAddr=" + empAddr
				+ ", empNote=" + empNote + ", category=" + category + "]";
	}
	
	
	
	
	
	

}
