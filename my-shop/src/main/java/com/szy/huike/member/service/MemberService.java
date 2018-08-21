package com.szy.huike.member.service;

import java.util.List;

import com.szy.huike.member.pojo.Member;
import com.szy.huike.member.pojo.MemberGrade;

public interface MemberService {

	
		/**
		 * 保存或者修改会员信息
		 */
	int saveOrUpdateMember(Member member); 
		/**
		 * 保存会员等级信息
		 * @param memberGrade
		 * @return
		 */
	int saveOrUpdateMemberGrade(MemberGrade memberGrade); 
	 
	Object[] showMemberGradeForPage(String cname, int begin, int size);
	 
	void updateGradeById(Integer gradeId);
	
	List<MemberGrade> showGradeName();
	
	
	void delMemberGradeById(int gradeId);
	
	MemberGrade findMemberGradeById(int gradeId);
	
	Member findMemberById(int memberId);
		
		
}
