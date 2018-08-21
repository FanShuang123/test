package com.szy.huike.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.szy.huike.member.pojo.Member;
import com.szy.huike.member.pojo.MemberGrade;
@Repository
public interface MemberMapper {

	
	/**
	 * 保存会员信息
	 * @param member
	 * @return
	 */
	int saveMember(Member member); 
		/**
		 * 更新会员
		 * @param member
		 * @return
		 */
	int updateMember(Member member);
		/**
		 *  保存会员等级信息
		 * @author fanshuang
		 * @param memberGrade
		 * @return
		 * 
		 */
	int saveMemberGrade(MemberGrade memberGrade);

	int updateMemberGrade(MemberGrade memberGrade);  //修改会员等级信息

	/**
	 * 
	 * @return 
	 */
	List<MemberGrade> showMemberGrade();
	
	Long getCount(String cname);
	
	List<MemberGrade> showMemberGradeForPage(Map<String, Object> map);
	
	/**
	 * 		
	 * @param gradeId
	 */
	void updateGradeById(Integer gradeId);  //更新等级
	
	List<MemberGrade> showGradeName();  //查询所有会员等级
	
	void delMemberGradeById(int gradeId);  //删除当前等级  实际上是把id的状态改成0
	
	MemberGrade findMemberGradeById(int gradeId); //查找当前id的等级信息
	
	Member findMemberById(int memberId); //查找当前id的等级信息
	
	List<MemberGrade> showGradeById(int id);  //查询所有会员等级详细信息
}
