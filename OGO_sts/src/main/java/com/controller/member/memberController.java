package com.controller.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
			if (dto.getUserName().equals("관리자")) {
				session.setAttribute("admin", "admin");
			}
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
		return "managementMember";
	}
	
// 회원가입
	@RequestMapping(value = "/createMember")
	private String createMember() {
		return "member/createMember/createMember";
	}

// 아이디 중복 검사
	@RequestMapping(value = "/idCheck")
	private String idCheck() {
		return "member/createMember/idCheck";
	}
	
// 아이디 중복 검사 - Ajax 비동기 처리
	@RequestMapping(value = "/memberIdCheck" , produces = "text/plain;charset=UTF-8")	// 한글처리
	@ResponseBody
	private String MemberIdCheck(@RequestParam("userId") String userId) {
		System.out.println(userId);

		String n = service.idCheck(userId);
		System.out.println("아이디 중복갯수"+n);
		return n;
	}
	
// 닉네임 중복 검사 - Ajax 비동기 처리
	@RequestMapping(value = "/MemberNicknameCheck" , produces = "text/plain;charset=UTF-8")	// 한글처리
	@ResponseBody
	private String MemberNicknameCheck(@RequestParam("nickname") String nickname) {
		System.out.println(nickname);

		String n = service.nicknameCheck(nickname);
		System.out.println("닉네임 중복갯수"+n);
		return n;
	}
	

			

	

}
