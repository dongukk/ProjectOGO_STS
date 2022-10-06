package com.controller.mypage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.member.MemberDTO;
import com.service.mypage.MypageService;

@Controller
public class MyPageController {
	
	@Autowired
	MypageService service;
	
	
	@RequestMapping(value = "/loginCheck/Mypage")
	public String getMemberData(HttpSession session) {
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		System.out.println(dto);
		return "MyPageMain";
	}
	
	
	@RequestMapping(value = "/loginCheck/ChangePW")
	public String ChangePW(String passwd, HttpSession session, RedirectAttributes attr) {
		MemberDTO Mdto =(MemberDTO) session.getAttribute("login");
		String userid = Mdto.getUserId();
		service.ChangePW(userid, passwd);
		attr.addAttribute("mesg","성공적으로 비밀번호를 변경했습니다!");
		return "redirect:../loginCheck/MyPageMain";
	}
	
	@RequestMapping(value = "/loginCheck/MyPageMain")
	public String Mypage(HttpSession session) {
		return "MyPageMain";
	}
	
	@RequestMapping(value = "/loginCheck/CheckID")
	@ResponseBody
	public String CheckID(String userid) {
		System.out.println(userid);
		
		String Count = "";
		int ID = service.CheckID(userid);
		if (ID == 0) {
			Count = "NOoverlap";
		}else {
			Count = "overlap";
		}
		return Count;
	}
	
}
