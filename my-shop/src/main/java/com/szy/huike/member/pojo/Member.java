package com.szy.huike.member.pojo;

import java.math.BigDecimal;
import java.sql.Date;

/**一个会员卡代表一个人+1张卡,  不用一对多
 * 会员实体类  对应数据库 member 表
 * @author fanshuang
 *
 */
public class Member {
		
	
	private Integer memId;  //id  
	
	private String  memName;   //会员姓名
	
	private String  memPwd;   //会员密码
	
	private Integer memCardNum; //会员卡号
	
	private String  memBirType;   //生日类型     农历或者阴历
	
	private Integer memTel;   //会员电话
	
	private String  memBirthday;  //会员生日    //sql包下的date类型没有日期时间
	
	private String  recommendName;   //推荐人姓名
	
	private String  memNote;   //会员备注
	
	private String  memSex;   //会员性别
	
	private String memGradeName;  //会员等级   //只存放名字
	
	private MemberGrade grade; //会员等级信息
	
	private BigDecimal sellCardMoney;   //售卡金额
	
	private BigDecimal memCardBalance;   //卡上余额
	
	private String memCardState;  //卡片状态     挂失 正常  还是冻结   或者失效
	
	private Date memCardExpires ; // 卡片到期时间
	
	private Integer memCardScore ; // 会员卡积分
	
	private java.util.Date memRegTime ; // 会员登记时间

	
	
	public MemberGrade getGrade() {
		return grade;
	}
	
	public void setGrade(MemberGrade grade) {
		this.grade = grade;
	}
	
	public java.util.Date getMemRegTime() {
		return memRegTime;
	}
	
	public void setMemRegTime(java.util.Date memRegTime) {
		this.memRegTime = memRegTime;
	}

	public Integer getMemId() {
		return memId;
	}


	public void setMemId(Integer memId) {
		this.memId = memId;
	}


	public void setMemBirthday(String memBirthday) {
		this.memBirthday = memBirthday;
	}


	public String getMemName() {
		return memName;
	}


	public void setMemName(String memName) {
		this.memName = memName;
	}


	public String getMemPwd() {
		return memPwd;
	}


	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}


	public Integer getMemCardNum() {
		return memCardNum;
	}


	public void setMemCardNum(Integer memCardNum) {
		this.memCardNum = memCardNum;
	}

	public String getMemBirType() {
		return memBirType;
	}
	
	public String getMemBirthday() {
		return memBirthday;
	}
	public void setMemBirType(String memBirType) {
		this.memBirType = memBirType;
	}
	public String getRecommendName() {
		return recommendName;
	}
	public void setRecommendName(String recommendName) {
		this.recommendName = recommendName;
	}


	public String getMemNote() {
		return memNote;
	}

	public void setMemNote(String memNote) {
		this.memNote = memNote;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (memBirType == null) {
			if (other.memBirType != null)
				return false;
		} else if (!memBirType.equals(other.memBirType))
			return false;
		if (memBirthday == null) {
			if (other.memBirthday != null)
				return false;
		} else if (!memBirthday.equals(other.memBirthday))
			return false;
		if (memCardBalance == null) {
			if (other.memCardBalance != null)
				return false;
		} else if (!memCardBalance.equals(other.memCardBalance))
			return false;
		if (memCardExpires == null) {
			if (other.memCardExpires != null)
				return false;
		} else if (!memCardExpires.equals(other.memCardExpires))
			return false;
		if (memCardNum == null) {
			if (other.memCardNum != null)
				return false;
		} else if (!memCardNum.equals(other.memCardNum))
			return false;
		if (memCardScore == null) {
			if (other.memCardScore != null)
				return false;
		} else if (!memCardScore.equals(other.memCardScore))
			return false;
		if (memCardState == null) {
			if (other.memCardState != null)
				return false;
		} else if (!memCardState.equals(other.memCardState))
			return false;
		if (memGradeName == null) {
			if (other.memGradeName != null)
				return false;
		} else if (!memGradeName.equals(other.memGradeName))
			return false;
		if (memId == null) {
			if (other.memId != null)
				return false;
		} else if (!memId.equals(other.memId))
			return false;
		if (memName == null) {
			if (other.memName != null)
				return false;
		} else if (!memName.equals(other.memName))
			return false;
		if (memNote == null) {
			if (other.memNote != null)
				return false;
		} else if (!memNote.equals(other.memNote))
			return false;
		if (memPwd == null) {
			if (other.memPwd != null)
				return false;
		} else if (!memPwd.equals(other.memPwd))
			return false;
		if (memRegTime == null) {
			if (other.memRegTime != null)
				return false;
		} else if (!memRegTime.equals(other.memRegTime))
			return false;
		if (memSex == null) {
			if (other.memSex != null)
				return false;
		} else if (!memSex.equals(other.memSex))
			return false;
		if (memTel == null) {
			if (other.memTel != null)
				return false;
		} else if (!memTel.equals(other.memTel))
			return false;
		if (recommendName == null) {
			if (other.recommendName != null)
				return false;
		} else if (!recommendName.equals(other.recommendName))
			return false;
		if (sellCardMoney == null) {
			if (other.sellCardMoney != null)
				return false;
		} else if (!sellCardMoney.equals(other.sellCardMoney))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((memBirType == null) ? 0 : memBirType.hashCode());
		result = prime * result + ((memBirthday == null) ? 0 : memBirthday.hashCode());
		result = prime * result + ((memCardBalance == null) ? 0 : memCardBalance.hashCode());
		result = prime * result + ((memCardExpires == null) ? 0 : memCardExpires.hashCode());
		result = prime * result + ((memCardNum == null) ? 0 : memCardNum.hashCode());
		result = prime * result + ((memCardScore == null) ? 0 : memCardScore.hashCode());
		result = prime * result + ((memCardState == null) ? 0 : memCardState.hashCode());
		result = prime * result + ((memGradeName == null) ? 0 : memGradeName.hashCode());
		result = prime * result + ((memId == null) ? 0 : memId.hashCode());
		result = prime * result + ((memName == null) ? 0 : memName.hashCode());
		result = prime * result + ((memNote == null) ? 0 : memNote.hashCode());
		result = prime * result + ((memPwd == null) ? 0 : memPwd.hashCode());
		result = prime * result + ((memRegTime == null) ? 0 : memRegTime.hashCode());
		result = prime * result + ((memSex == null) ? 0 : memSex.hashCode());
		result = prime * result + ((memTel == null) ? 0 : memTel.hashCode());
		result = prime * result + ((recommendName == null) ? 0 : recommendName.hashCode());
		result = prime * result + ((sellCardMoney == null) ? 0 : sellCardMoney.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Member [memId=" + memId + ", memName=" + memName + ", memPwd=" + memPwd + ", memGrade=" + memGradeName
				+ ", memCardNum=" + memCardNum + ", memBirType=" + memBirType + ", memTel=" + memTel + ", memBirthday="
				+ memBirthday + ", recommendName=" + recommendName + ", memNote=" + memNote + ", memSex=" + memSex
				+ ", sellCardMoney=" + sellCardMoney + ", memCardBalance=" + memCardBalance + ", memCardState="
				+ memCardState + ", memCardExpires=" + memCardExpires + ", memCardScore=" + memCardScore
				+ ", memRegTime=" + memRegTime + "]";
	}

	public String getMemGradeName() {
		return memGradeName;
	}


	public void setMemGradeName(String memGrade) {
		this.memGradeName = memGrade;
	}


	public Integer getMemTel() {
		return memTel;
	}


	public void setMemTel(Integer memTel) {
		this.memTel = memTel;
	}


	public String getMemSex() {
		return memSex;
	}


	public void setMemSex(String memSex) {
		this.memSex = memSex;
	}


	public BigDecimal getSellCardMoney() {
		return sellCardMoney;
	}


	public void setSellCardMoney(BigDecimal sellCardMoney) {
		this.sellCardMoney = sellCardMoney;
	}


	public BigDecimal getMemCardBalance() {
		return memCardBalance;
	}


	public void setMemCardBalance(BigDecimal memCardBalance) {
		this.memCardBalance = memCardBalance;
	}


	public String getMemCardState() {
		return memCardState;
	}


	public void setMemCardState(String memCardState) {
		this.memCardState = memCardState;
	}


	public Date getMemCardExpires() {
		return memCardExpires;
	}


	public void setMemCardExpires(Date memCardExpires) {
		this.memCardExpires = memCardExpires;
	}


	public Integer getMemCardScore() {
		return memCardScore;
	}


	public void setMemCardScore(Integer memCardScore) {
		this.memCardScore = memCardScore;
	}

	public Member(){ }

}
