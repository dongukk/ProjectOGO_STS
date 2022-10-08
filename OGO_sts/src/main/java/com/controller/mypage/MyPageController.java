package com.controller.mypage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.member.MemberDTO;
import com.service.member.MemberService;
import com.service.mypage.MypageService;

@Controller
public class MyPageController {
	
	@Autowired
	MypageService service;
	@Autowired
	MemberService Mservice;
	
	
	@RequestMapping(value = "/loginCheck/Mypage")
	public String getMemberData(HttpSession session , String userId, String userPasswd) {
		
		if (userPasswd != null || userId != null) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("userId", userId);
			map.put("userPasswd", userPasswd);
			MemberDTO dto =Mservice.login(map);
			
			session.removeAttribute("login");
			session.setAttribute("login", dto);
			
		}
		
		
		
		return "MyPageMain";
	}
	
	
	@RequestMapping(value = "/loginCheck/CheckID")
	@ResponseBody
	public String CheckID(String nickname, String Tnickname) {
		System.out.println(nickname); //성공
		
		String Count = "";
		String ID = service.CheckID(nickname);
		System.out.println("가져온"+ID);
		
		if ( ID == null ) {
			 Count = "-1"; 
			 System.out.println("사용가능"+ID+"\t"+nickname);
		}else if (ID == Tnickname || ID.equals(Tnickname)) {
			Count = "0";
			System.out.println("사용가능 현재"+ID+"\t"+nickname);
		}else { 
			Count = "1";
			System.out.println("사용불가능"+ID+"\t"+nickname);
		}
		return Count;
	}
	
	
	@RequestMapping(value = "/loginCheck/MemberUpdate")
	public String MemberUpdate(MemberDTO dto ) {
		if (dto.getHobby() == null) {
			dto.setHobby("");
		}
		System.out.println(dto);
		service.MemberUpdate(dto);
		return "redirect:../loginCheck/Mypage?userId="+dto.getUserId()+"&userPasswd="+dto.getUserPasswd();
	}
	
	
	@RequestMapping(value = "/MemberDelete")
	public String delete(String userId, HttpSession session) {
		System.out.println(userId);
		int n =Mservice.delete(userId);
		System.out.println("삭제된 개수 :"+ n);
		session.invalidate();
		return "/MainForm";
	}
	

	
}
