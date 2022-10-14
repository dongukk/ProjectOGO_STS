package com.controller.mypage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public String MemberUpdate(MultipartHttpServletRequest multi) {
		
		String userId = multi.getParameter("userId");
		String userPasswd = multi.getParameter("userPasswd");
		String nickname = multi.getParameter("nickname");
		String phone1 = multi.getParameter("phone1");
		String phone2 = multi.getParameter("phone2");
		String phone3 = multi.getParameter("phone3");
		String post = multi.getParameter("post");
		String address1 = multi.getParameter("address1");
		String address2 = multi.getParameter("address2");
		String email1 = multi.getParameter("email1");
		String email2 = multi.getParameter("email2");	
		String[] hobby = multi.getParameterValues("hobby");
		
		String Profile = multi.getParameter("mimg");
		MultipartFile changeProfile = multi.getFile("changeProfile");

		MemberDTO dto = new MemberDTO();
		dto.setUserId(userId);
		dto.setUserPasswd(userPasswd);
		dto.setNickname(nickname);
		dto.setPhone1(phone1);
		dto.setPhone2(phone2);
		dto.setPhone3(phone3);
		dto.setPost(post);
		dto.setAddress1(address1);
		dto.setAddress2(address2);
		dto.setEmail1(email1);
		dto.setEmail2(email2);
		if(hobby == null) {
			dto.setHobby("");
		} else {
			String hobbys = String.join(",", hobby);
			dto.setHobby(hobbys);
		}
		if(changeProfile.getSize() != 0) {
			System.out.println("변경할 프로필이미지가 있습니다.");
			fileDelete(userId);
			
//			String realPath = "C:\\Users\\UserK\\git\\ProjectOGO_STS\\OGO_sts\\src\\main\\webapp\\WEB-INF\\views";
			String realPath = "C:\\Users\\qkdnv\\git\\ProjectOGO_STS\\OGO_sts\\src\\main\\webapp\\WEB-INF\\views";
			System.out.println("realPath : " + realPath);
			String root = realPath + "\\upload\\member";
			File file = new File(root);
			if(!file.exists()) file.mkdirs();
			String originFileName = changeProfile.getOriginalFilename();
			String ext = originFileName.substring(originFileName.lastIndexOf("."));
			String ranFileName = UUID.randomUUID().toString() + ext;
			File changeFile = new File(root + "\\" + ranFileName);
			try {
				changeProfile.transferTo(changeFile);
				System.out.println("파일 업로드 성공");
			} catch (IllegalStateException | IOException e) {
				System.out.println("파일 업로드 실패");
				e.printStackTrace();
			}
			String profilePhoto = ranFileName;
			System.out.println("파일있음 : "+profilePhoto);
			dto.setProfilePhoto(profilePhoto);
			
		} else {
			System.out.println("변경할 프로필 없음.");
			dto.setProfilePhoto(Profile);
		}

		System.out.println(dto);
		service.MemberUpdate(dto);
		HttpSession session = multi.getSession();
		session.setAttribute("mesg",nickname+"님 정보가 변경되었습니다.");
		return "redirect:../loginCheck/Mypage?userId="+userId+"&userPasswd="+userPasswd;
	}
	
	
	@RequestMapping(value = "/MemberDelete")
	public String delete(String userId, HttpSession session) {
		System.out.println(userId);
		int n =Mservice.delete(userId);
		System.out.println("삭제된 개수 :"+ n);
		session.invalidate();
		return "/MainForm";
	}
	
	@RequestMapping(value = "/photoch")
	public String photoch() {
		return "/mypage/photoch";
	}
	
	
	@RequestMapping(value = "/change/profilePhoto")
	@ResponseBody
	public String changeProfile(MultipartHttpServletRequest multi) {
		MultipartFile changeProfile = multi.getFile("changeProfile");
		return "changeProfile";
	}
	
// 프로필사진 삭제
	private void fileDelete(String userId) {
		System.out.println("프로필 사진 삭제 Id : "+userId);
		// 파일의 경로 + 파일명
		String fileName = Mservice.fileName(userId);		
		System.out.println(">>>>>>>>>>>fileName : "+fileName);
 //     String filePath = "C:\\Users\\UserK\\git\\ProjectOGO_STS\\OGO_sts\\src\\main\\webapp\\WEB-INF\\views\\upload\\member\\"+fileName;
		String filePath = "C:\\Users\\qkdnv\\git\\ProjectOGO_STS\\OGO_sts\\src\\main\\webapp\\WEB-INF\\views\\upload\\member\\"+fileName;
		System.out.println(">>>>>>>>>>>filePath : "+filePath);
        File deleteFile = new File(filePath);
 
        // 파일이 존재하는지 체크 존재할경우 true, 존재하지않을경우 false
        if(deleteFile.exists()) {
        	if(fileName.equals("noImage.jpg")) {
    			System.out.println("프로필 사진 기본값이므로 삭제할수없습니다.");
    		} else {
    			// 파일을 삭제합니다.
    			deleteFile.delete(); 
    			System.out.println("파일을 삭제하였습니다.");
    		}   
        } else {
            System.out.println("파일이 존재하지 않습니다.");
        }
	}
	
}
