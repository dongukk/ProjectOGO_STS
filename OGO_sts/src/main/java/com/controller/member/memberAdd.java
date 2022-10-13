package com.controller.member;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dto.member.MemberDTO;
import com.service.member.MemberService;

@Controller
public class memberAdd {

	@Autowired
	MemberService service;
	
// 회원가입 
	@RequestMapping(value = "/MemberAdd" , method = RequestMethod.POST)
	private String MemberAdd(MultipartHttpServletRequest multi) {
		
		// 1. 전송받은 파일 및 파일설명 값 가져오기	
		String userId = multi.getParameter("userId");
		String userPasswd = multi.getParameter("userPasswd");
		String userName = multi.getParameter("userName");
		String nickname = multi.getParameter("nickname");
		String gender = multi.getParameter("gender");
		String birth = multi.getParameter("birth");
		String phone1 = multi.getParameter("phone1");
		String phone2 = multi.getParameter("phone2");
		String phone3 = multi.getParameter("phone3");
		String post = multi.getParameter("post");
		String address1 = multi.getParameter("address1");
		String address2 = multi.getParameter("address2");
		String email1 = multi.getParameter("email1");
		String email2 = multi.getParameter("email2");
		String[] hobby = multi.getParameterValues("hobby");
		MultipartFile upload = multi.getFile("profilePhoto");

		// dto 저장
		MemberDTO dto = new MemberDTO();
		dto.setUserId(userId);
		dto.setUserPasswd(userPasswd);
		dto.setUserName(userName);
		dto.setNickname(nickname);
		dto.setGender(gender);
		String birth1 = birth.substring(0,10);	// 시간이 같이 저장되서 데이터 잘라서 날짜만 저장
		dto.setBirth(birth1);
		dto.setPhone1(phone1);
		dto.setPhone2(phone2);
		dto.setPhone3(phone3);
		dto.setPost(post);
		dto.setAddress1(address1);
		dto.setAddress2(address2);
		dto.setEmail1(email1);
		dto.setEmail2(email2);

// 파일업로드 존재시
	if(upload.getSize() != 0) {
		System.out.println("파일있음");

		// 2. 저장할 경로 가져오기
//		String path = request.getSession().getServletContext().getRealPath("views");
		String realPath = "C:\\Users\\UserK\\git\\ProjectOGO_STS\\OGO_sts\\src\\main\\webapp\\WEB-INF\\views";
		System.out.println("realPath : " + realPath);
		String root = realPath + "\\upload\\member";
		
		File file = new File(root);
		
		// 만약 upload 폴더가 없으면 생성해라 라는뜻
		if(!file.exists()) file.mkdirs();
				
		// 업로드할 폴더 설정
		String originFileName = upload.getOriginalFilename();
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		String ranFileName = UUID.randomUUID().toString() + ext;
		File changeFile = new File(root + "\\" + ranFileName);
		
		// 파일업로드
		try {
			upload.transferTo(changeFile);
			System.out.println("파일 업로드 성공");
		} catch (IllegalStateException | IOException e) {
			System.out.println("파일 업로드 실패");
			e.printStackTrace();
		}
		
		System.out.println("ext : "+ext);
		System.out.println("ranFileName : "+ranFileName);
		System.out.println("changeFile : "+changeFile);
			
		String profilePhoto = ranFileName;
		System.out.println("파일있음 : "+profilePhoto);
		dto.setProfilePhoto(profilePhoto);
		
		// 파일업로드 안할 시 기본값 설정
		}else {
			String profilePhoto = "noImage.jpg";
			System.out.println("파일없음 : "+profilePhoto);
			dto.setProfilePhoto(profilePhoto);
		}
		
// 취미배열 string타입으로 변형
		if(hobby == null) {	// 취미가 없으면 null값입력
			dto.setHobby("");
		} else {	// 취미가 있으면 사이에 ,삽입(하나있으면 콤마삽입안함.)
			String hobbys = String.join(",", hobby);
			dto.setHobby(hobbys);
		}		
		System.out.println(dto);
		
		int n = service.memberAdd(dto);
		System.out.println("insert 갯수"+n);

		if(n==1) {
			HttpSession session = multi.getSession();
			session.setAttribute("mesg",nickname+"님 회원가입을 환영합니다.");
			session.setAttribute("login",dto);
			session.setMaxInactiveInterval(60*30);
			return "MainForm";
		}	
		return "MainForm";
	}
}
