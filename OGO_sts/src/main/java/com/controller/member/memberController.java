package com.controller.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.member.MemberDTO;
import com.service.member.MemberService;

@Controller
public class memberController {
	
	@Autowired
	MemberService service;

// 로그인 처리
	@RequestMapping(value = "/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session) {
		//System.out.println(map);
		
		MemberDTO dto = service.login(map);
		System.out.println(dto);		
		if (dto != null) {
			session.setAttribute("login", dto);
			return "redirect:/MainForm";	
		} else {
			session.setAttribute("mesg", "아이디 또는 비번이 잘못되었습니다.");
			return "redirect:/MainForm";
		}
	}
	
// 로그아웃 처리	
	@RequestMapping(value = "/loginCheck/logout")
	private String logout(HttpSession session) {
		session.invalidate();
		return "redirect:../";
	}
	
// 회원관리 페이지
	
	@RequestMapping(value = "/loginCheck/managementMember")
	private String managementMember() {
		return "member/manageMember/managementMember";
	}
}
