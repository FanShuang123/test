package com.szy.huike.member.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szy.huike.member.dao.MemberMapper;
import com.szy.huike.member.pojo.Member;
import com.szy.huike.member.pojo.MemberGrade;
import com.szy.huike.member.service.MemberService;

@Service
public  class MemberServiceImpl implements MemberService{

	@Autowired
	 private MemberMapper memberMapper;
	
	
	/**
	 * 保存或者修改会员信息
	 */
	@Override
	public int saveOrUpdateMember(Member member) {
		System.out.println(member.getMemId());
		if(null==member.getMemId()){
			return memberMapper.saveMember(member);}
		else {
			return memberMapper.updateMember(member);
		}
		
	}

	
		@Override
		public int saveOrUpdateMemberGrade(MemberGrade memberGrade) {
			System.out.println(memberGrade.getGradeId());
			if(null==memberGrade.getGradeId()){
				return memberMapper.saveMemberGrade(memberGrade);}
			else {
				return memberMapper.updateMemberGrade(memberGrade);
				 
			}
		
		}

		@Override
		public void delMemberGradeById(int gradeId) {
			memberMapper.delMemberGradeById(gradeId); 
		}


		@Override
		public Object[] showMemberGradeForPage(String cname, int begin, int size) {
			Long count = memberMapper.getCount(cname);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", cname);
			map.put("begin", begin);
			map.put("size", size); 
			List <MemberGrade> memberGradeList=memberMapper.showMemberGradeForPage(map);
			return new Object[]{count,memberGradeList};
		}


		@Override
		public Member findMemberById(int memberId) {
			return memberMapper.findMemberById(memberId);
		}


		@Override 
		public void updateGradeById(Integer gradeId) {
			    
			 memberMapper.updateGradeById(gradeId);
		}

		@Override
		public List<MemberGrade> showGradeName() {
			return memberMapper.showGradeName();
		}


		@Override
		public MemberGrade findMemberGradeById(int gradeId) {
			
			return  memberMapper.findMemberGradeById(gradeId);
			
		}


	
 

 

}
