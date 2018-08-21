package com.szy.huike.member.view;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.szy.common.base.BaseAction;
import com.szy.huike.member.pojo.Member;
import com.szy.huike.member.pojo.MemberGrade;
import com.szy.huike.member.service.MemberService;



@Controller
public class MemberAction extends BaseAction{
	
	
	@Autowired
	private MemberService memberService;
	
	
	

	public void findMemberById(int gradeId){
		
		System.out.println(gradeId);
		
		Member m = memberService.findMemberById(gradeId);
		
		
	}
	
	
	/**
	 * 写出当前id对应的等级信息
	 * @param response
	 * @param gradeId
	 */
	@RequestMapping(value="/findMemberGradeById")
	public void findMemberGradeById(HttpServletResponse response,int gradeId){
		
		
		MemberGrade m = memberService.findMemberGradeById(gradeId);
		
		writeJson(response, m);
	}
	
	
	
	/**
	 * 添加member  会员(信息)
	 * @param member
	 */
	@RequestMapping(value="/addMember")
	public void addMember(Member member){
		
		System.out.println(	memberService.saveOrUpdateMember(member));
		
	}
	
	
	/**
	 *  grade.js里的ajax  添加会员等级
	 * @param memberGrade
	 */
	@RequestMapping(value="/addMemberGrade")
	public void addMemberGrade(MemberGrade memberGrade){
		memberService.saveOrUpdateMemberGrade(memberGrade);	
	}
	
	
	@RequestMapping(value="/showMemberGradeForPage")
	public void showMemberGradeForPage(HttpServletResponse response,@RequestParam(value="begin",defaultValue="0")  int begin ,
			@RequestParam(value="size",defaultValue="10")int size ){
		
		String cname="%%";
//	  List<MemberGrade> memberGradeList=memberService.showMemberGradeForPage();
	  
		Object [] obj=memberService.showMemberGradeForPage(cname,begin,size);
		writeJson(response, obj);
		
	}
	
	@RequestMapping(value="/updateGradeById")
	public void updateGradeById(int gradeId){
		
		System.out.println(gradeId);
		memberService.updateGradeById(gradeId);
	}
	
	/**
	 * 先展示所有的等级名称
	 * @url member.js
	 * @param response
	 */
	@RequestMapping(value="/showGradeName")
	public void showGradeName(HttpServletResponse response){
		
		List<MemberGrade> showGradeName = memberService.showGradeName();
		
		writeJson(response, showGradeName);
	}
	@RequestMapping(value="/delMemberGradeById")
	public void delMemberGradeById(int gradeId){
		memberService.delMemberGradeById(gradeId);
		
	}
	
}
