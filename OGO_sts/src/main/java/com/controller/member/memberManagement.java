package com.controller.member;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.member.PageDTO;
import com.service.member.MemberService;

@Controller
public class memberManagement {
	
	@Autowired
	MemberService service;
	

// 회원관리 페이지
	@RequestMapping(value = "/AdminCheck/managementMember")
	private String managementMember(HttpServletRequest request) {
		String curPage = request.getParameter("curPage");//현재페이지 
		if(curPage == null) curPage = "1";//시작시 현재페이지 1 
		
		String searchName = request.getParameter("searchName");
		String searchValue = request.getParameter("searchValue");
		String order = request.getParameter("order");
		System.out.println(searchName+"\t"+searchValue+"\t"+order);
		if(order == null) {order = "asc";}
		
		PageDTO pDTO = service.search(searchName, searchValue, Integer.parseInt(curPage), order);
		request.setAttribute("pDTO", pDTO);
		request.setAttribute("searchName", searchName);
		request.setAttribute("searchValue", searchValue);
		request.setAttribute("order", order);

		return "managementMember";
	}

// 회원 다중 삭제
	@RequestMapping(value = "/AdminCheck/deleteAllMember")
	private String deleteAllMember(HttpServletRequest request, HttpSession session) {
		String [] userIds = request.getParameterValues("delCheck");
		if(userIds==null) {
			session.setAttribute("mesg", "삭제할 회원을 체크해주세요.");
			return "redirect:managementMember";
		}else {
		    List<String> list = Arrays.asList(userIds);
		    System.out.println("deleteAllMember : "+list);
	
		    int n = service.deleteAll(list);
		    System.out.println("선택회원 삭제 : "+n);
		    if(n > 0) {	
		    	session.setAttribute("mesg", "회원"+list+"을(를) 탈퇴시켰습니다.");
		    }
			return "redirect:managementMember";
		}
	}

// 회원 단일 삭제
	@RequestMapping(value = "/AdminCheck/deleteMember")
	private String deleteMember(HttpServletRequest request, HttpSession session) {
		String userId = request.getParameter("userId");
		System.out.println("삭제할 회원 : "+userId);

	    int n = service.delete(userId);
	    if(n > 0) {	 
	    	session.setAttribute("mesg", "회원"+userId+"을(를) 탈퇴시켰습니다.");
	    }
		return "redirect:managementMember";
	}
	
	
}
