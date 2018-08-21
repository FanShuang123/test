package com.szy.huike.member.pojo;

import java.math.BigDecimal;

/**
 * 会员等级   对应  member_grade
 * @author fanshuang
 *
 */
public class MemberGrade {
	
	private Integer gradeId;
	
	private String gradeName;  	//等级名称  
	
	private Integer gradeScore;    	//所需积分    
	
	private Integer gradeState;    	//等级的状态. 
	
	private BigDecimal gradeExchangeRatio  ; // 积分兑换比例         (即：消费10人民币自动兑换成一个积分，默认：10RMB-1积分)
	
	private BigDecimal gradeGeneralDisRatio;  //普通折扣比例  (即：折扣率 0.8表示八折，1表示不打折)
	
	private BigDecimal gradeServeDisRatio  ; // 服务折扣比例  (即：消费10人民币自动兑换成一个积分，默认：10RMB-1积分)
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gradeExchangeRatio == null) ? 0 : gradeExchangeRatio.hashCode());
		result = prime * result + ((gradeGeneralDisRatio == null) ? 0 : gradeGeneralDisRatio.hashCode());
		result = prime * result + ((gradeId == null) ? 0 : gradeId.hashCode());
		result = prime * result + ((gradeName == null) ? 0 : gradeName.hashCode());
		result = prime * result + ((gradeScore == null) ? 0 : gradeScore.hashCode());
		result = prime * result + ((gradeServeDisRatio == null) ? 0 : gradeServeDisRatio.hashCode());
		result = prime * result + ((gradeState == null) ? 0 : gradeState.hashCode());
		return result;
	}
	
	public MemberGrade() {}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberGrade other = (MemberGrade) obj;
		if (gradeExchangeRatio == null) {
			if (other.gradeExchangeRatio != null)
				return false;
		} else if (!gradeExchangeRatio.equals(other.gradeExchangeRatio))
			return false;
		if (gradeGeneralDisRatio == null) {
			if (other.gradeGeneralDisRatio != null)
				return false;
		} else if (!gradeGeneralDisRatio.equals(other.gradeGeneralDisRatio))
			return false;
		if (gradeId == null) {
			if (other.gradeId != null)
				return false;
		} else if (!gradeId.equals(other.gradeId))
			return false;
		if (gradeName == null) {
			if (other.gradeName != null)
				return false;
		} else if (!gradeName.equals(other.gradeName))
			return false;
		if (gradeScore == null) {
			if (other.gradeScore != null)
				return false;
		} else if (!gradeScore.equals(other.gradeScore))
			return false;
		if (gradeServeDisRatio == null) {
			if (other.gradeServeDisRatio != null)
				return false;
		} else if (!gradeServeDisRatio.equals(other.gradeServeDisRatio))
			return false;
		if (gradeState == null) {
			if (other.gradeState != null)
				return false;
		} else if (!gradeState.equals(other.gradeState))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MemberGrade [gradeId=" + gradeId + ", gradeName=" + gradeName + ", gradeScore=" + gradeScore
				+ ", gradeState=" + gradeState + ", gradeExchangeRatio=" + gradeExchangeRatio
				+ ", gradeGeneralDisRatio=" + gradeGeneralDisRatio + ", gradeServeDisRatio=" + gradeServeDisRatio + "]";
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	
	public Integer getGradeState() {
		return gradeState;
	}
	
	public void setGradeState(Integer gradeState) {
		this.gradeState = gradeState;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public Integer getGradeScore() {
		return gradeScore;
	}
	public void setGradeScore(Integer gradeScore) {
		this.gradeScore = gradeScore;
	}
	public BigDecimal getGradeExchangeRatio() {
		return gradeExchangeRatio;
	}
	public void setGradeExchangeRatio(BigDecimal gradeExchangeRatio) {
		this.gradeExchangeRatio = gradeExchangeRatio;
	}
	public BigDecimal getGradeGeneralDisRatio() {
		return gradeGeneralDisRatio;
	}
	public void setGradeGeneralDisRatio(BigDecimal gradeGeneralDisRatio) {
		this.gradeGeneralDisRatio = gradeGeneralDisRatio;
	}
	public BigDecimal getGradeServeDisRatio() {
		return gradeServeDisRatio;
	}
	public void setGradeServeDisRatio(BigDecimal gradeServeDisRatio) {
		this.gradeServeDisRatio = gradeServeDisRatio;
	}
	
//	private 
//	private 
	
//	private int num==1;
	
	

}
