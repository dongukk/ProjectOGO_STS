package com.controller.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
			session.setAttribute("mesg", dto.getNickname()+"님 어서오세요.");
			if (dto.getUserName().equals("관리자")) {
				session.setAttribute("admin", "admin");
			}			
		} else {
			session.setAttribute("mesg", "아이디 또는 비번이 잘못되었습니다.");
		}
		return "redirect:MainForm";	
	}
	
// 로그아웃 처리	
	@RequestMapping(value = "/loginCheck/logout")
	private String logout(HttpSession session) {
		session.invalidate();
		return "redirect:../";
	}
	
// id, pw 찾기
	@RequestMapping(value = "/findId_Pw")
	private String findId_Pw() {
		return "findId_Pw";
	}
// id 찾기
	@RequestMapping(value = "/findId")
	private String findId() {
		return "findId";
	}	
// id2 찾기
	@RequestMapping(value = "/findId2")
	private String findId2(String findName, String findEmail, HttpServletRequest request) {
		System.out.println(findName+"\t"+findEmail);
		
		int emailSplit = findEmail.indexOf('@');
		System.out.println("@위치 : "+emailSplit);
		String findEmail1 = findEmail.substring(0,emailSplit);
		String findEmail2 = findEmail.substring(emailSplit+1);
		System.out.println(findEmail1+"\t"+findEmail2);
		
		HashMap<String, String> map = new HashMap<>();
		map.put("findName", findName);
		map.put("findEmail1", findEmail1);
		map.put("findEmail2", findEmail2);
		System.out.println(map);

		MemberDTO dto = service.findId(map);
		System.out.println(dto);
		if(dto!=null) {
			request.setAttribute("userId", dto.getUserId());		
		} else {
			request.setAttribute("userId", null);
		}
		return "findId2";
	}	
	
// pw 찾기
	@RequestMapping(value = "/findPw")
	private String findPw() {
		return "findPw";
	}
// pw2 찾기
	@RequestMapping(value = "/findPw2")
	private String findPw2(String findId, String findEmail, HttpServletRequest request) {
		System.out.println(findId+"\t"+findEmail);
		
		int emailSplit = findEmail.indexOf('@');
		System.out.println("@위치 : "+emailSplit);
		String findEmail1 = findEmail.substring(0,emailSplit);
		String findEmail2 = findEmail.substring(emailSplit+1);
		System.out.println(findEmail1+"\t"+findEmail2);
		
		HashMap<String, String> map = new HashMap<>();
		map.put("findId", findId);
		map.put("findEmail1", findEmail1);
		map.put("findEmail2", findEmail2);
		
		MemberDTO dto = service.findPw(map);
		System.out.println(dto);
		if(dto!=null) {
			request.setAttribute("userId", dto.getUserId());		
		} else {
			request.setAttribute("userId", null);
		}	
		return "findPw2";
	
	}	
	
// 비밀번호 변경
	@RequestMapping(value = "/PwUpdate")
	private String PwUpdate(String userId, String newPw, HttpSession session) {
		System.out.println(userId+"\t"+newPw);
		
		HashMap<String, String> map = new HashMap<>();
		map.put("userId", userId);
		map.put("newPw", newPw);
		
		int n = service.newPw(map);
		System.out.println("newPw 업데이트 갯수"+n);

		session.setAttribute("mesg", "비밀번호가 변경되었습니다.");
		return "MainForm";
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
	
// 카카오 로그인
	@RequestMapping(value = "/kakaoLogin")
	private String kakaoLogin(HttpServletRequest request, HttpSession session) {
		String nickname = request.getParameter("nickname");	
		String email = request.getParameter("email");
		int emailSplit = email.indexOf("@");  // @의 문자의 위치 값을 얻는다.
		String email1 = email.substring(0, emailSplit);
		String email2 = email.substring(emailSplit+1, email.length());	 
		System.out.println(nickname+"\t"+email1+"\t"+email2);
		
		 String userId = email1+"@kakao.com";	// 네이버로그인 아이디와 같아서 임의로 변경
		 String userName = "카카오test";
		 String userPasswd = "1";
		 String gender = "남자";
		 String birth = "1990/02/04";
		 String phone1 = "010";
		 String phone2 = "1111";
		 String phone3 = "1111";
		 String post = "05399";
		 String address1 = "서울 강동구 성내로8길 9-11 (성내동)";
		 String address2 = "서울 강동구 성내동 550-10";
		 String profilePhoto = "noImage.jpg";	
		 String hobbys = "";
		 
		 MemberDTO dto = new MemberDTO();
			dto.setUserId(userId);
			dto.setUserPasswd(userPasswd);
			dto.setUserName(userName);
			dto.setNickname(nickname);
			dto.setGender(gender);
			dto.setBirth(birth);
			dto.setPhone1(phone1);
			dto.setPhone2(phone2);
			dto.setPhone3(phone3);
			dto.setPost(post);
			dto.setAddress1(address1);
			dto.setAddress2(address2);
			dto.setEmail1(email1);
			dto.setEmail2(email2);
			dto.setProfilePhoto(profilePhoto);	
			dto.setHobby(hobbys);
			System.out.println(dto);
			
			// 아이디 중복체크
			int n1 = Integer.parseInt(service.idCheck(userId));	
			System.out.println("아이디중복 갯수"+n1);
			// 카카오 로그인 처음이면 자동 회원가입db 저장	
			if(n1==0) {
				int n2 = service.memberAdd(dto);
				System.out.println("insert 갯수"+n2);		
				if(n2==1) {				
					session.setAttribute("mesg",nickname+"님 회원가입을 환영합니다.");	
				}		
			}
			session.setAttribute("login",dto);
			session.setMaxInactiveInterval(60*30);
			return "redirect:MainForm";
	}
			

	

}
