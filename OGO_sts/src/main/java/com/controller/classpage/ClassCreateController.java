package com.controller.classpage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.classpage.ClassDTO;
import com.dto.classpage.ClassImgDTO;
import com.dto.classpage.ContentDTO;
import com.dto.member.MemberDTO;
import com.service.classpage.ClassPageService;
import com.service.classpage.ContentService;

@Controller
public class ClassCreateController {
	@Autowired
	ClassPageService cService;
	@Autowired
	ContentService conService;
	
	@RequestMapping(value = "/loginCheck/ClassCreate")
	public String classCreate(HttpSession session, RedirectAttributes attr) {
		MemberDTO mDTO=(MemberDTO) session.getAttribute("login");
		if (mDTO!=null) {
			String userId=mDTO.getUserId();
			String tintroduce=cService.getTintroduce(userId);//튜터소개
			System.out.println("tintroduce:"+tintroduce);
			attr.addFlashAttribute("tintroduce", tintroduce);//튜터소개 저장
		}
		return "redirect:../ClassCreateForm";
	}
	@RequestMapping(value = "/ClassCreateForm")
	public String ClassCreateForm(HttpSession session) {
		MemberDTO mDTO=(MemberDTO) session.getAttribute("login");
		if (mDTO!=null) {
			return "ClassCreateForm";
		} else {
			return "redirect:home2";
		}
	}
	
	@RequestMapping(value = "/ClassNameSearch", produces = "application/text;charset=utf8")
	@ResponseBody
	public String ClassNameSearch(@RequestParam("userId") String userId, 
			@RequestParam("className") String className ) {
		HashMap<String, Object> classMap= new HashMap<String, Object>();
		classMap.put("userId", userId);
		classMap.put("className", className);
		//튜터의 클래스 중 동일 클래스명이 있는지 검사
		int result =cService.searchClassName(classMap); 
		String mesg="";
		if (result > 0) { //있는 경우
			mesg="이미 등록한 클래스명입니다. 다른 클래스명을 입력해주세요";
		} else { //없는 경우
			mesg="등록 가능한 클래스명입니다";
		}
		return mesg;
	}
	@RequestMapping(value = "/ClassCategory", produces = "application/text;charset=utf8")
	@ResponseBody
	public String ClassCategory(@RequestParam("sCategory") String sCategory,
			HttpSession session) {
		System.out.println(sCategory);
		//서브카테고리 정보 session에 저장
		session.setAttribute("sCategory", sCategory);
		return sCategory;
	}
	@RequestMapping(value = "/ClassAdd")
	//@ResponseBody
	public String ClassAdd(MultipartHttpServletRequest multi, ClassDTO cDTO, ContentDTO conDTO, 
			@RequestParam("classStartTime") String classStartTime,
			@RequestParam("classEndTime") String classEndTime,
			@RequestParam("post") String post,
			@RequestParam("address1") String address1,
			@RequestParam("address2") String address2, HttpSession session) {
//		System.out.println(cDTO+"\t"+conDTO+"\t"+classStartTime+"\t"
//			+classEndTime+"\t"+post+"\t"+address1+"\t"+address2);
		
		MemberDTO mDTO=(MemberDTO) session.getAttribute("login");
		String userId=mDTO.getUserId();
		cDTO.setUserId(userId);
		cDTO.setSchedule1(cDTO.getSchedule1().replace("&nbsp;", " "));
		cDTO.setSchedule2(cDTO.getSchedule2().replace("&nbsp;", " "));
		cDTO.setSchedule3(cDTO.getSchedule3().replace("&nbsp;", " "));
		cDTO.setSchedule4(cDTO.getSchedule4().replace("&nbsp;", " "));
		cDTO.setSchedule5(cDTO.getSchedule5().replace("&nbsp;", " "));
		cDTO.setSchedule6(cDTO.getSchedule6().replace("&nbsp;", " "));
		cDTO.setSchedule7(cDTO.getSchedule7().replace("&nbsp;", " "));
		cDTO.setSchedule8(cDTO.getSchedule8().replace("&nbsp;", " "));
		cDTO.setSchedule9(cDTO.getSchedule9().replace("&nbsp;", " "));
		cDTO.setSchedule10(cDTO.getSchedule10().replace("&nbsp;", " "));
		String place= "("+post+")"+address1+address2; //주소
		cDTO.setPlace(place);
		//System.out.println(cDTO);
		
		//class테이블에 저장
		int result =cService.classOpen(cDTO);
		System.out.println("클래스 등록 성공:"+result);
		//content 테이블에 저장
		  //1. classnum 먼저 받아오기
		String className= cDTO.getClassName();
		String tutorId= cDTO.getUserId();
		HashMap<String, String> classMap= new HashMap<String, String>();
		classMap.put("className", className);
		classMap.put("tutorId", tutorId);
		int classNum =cService.searchClassNum(classMap);
		System.out.println(className+"의 classNum:"+classNum);
		  //2. content 테이블에 저장하기
		conDTO.setClassNum(classNum);
		HashMap<String, Object> contentMap= new HashMap<String, Object>();
		contentMap.put("classNum", classNum);
		contentMap.put("conDTO", conDTO);
		int result2 =conService.saveContent(contentMap);
		System.out.println("content insert : "+ result2);
		
		//파일 업로드
		ClassImgDTO iDTO= new ClassImgDTO();
		iDTO.setClassNum(classNum);
		String[] photoArr= new String[5];
		String realPath="C:\\Users\\qkdnv\\git\\ProjectOGO_STS\\OGO_sts\\src\\main\\webapp\\WEB-INF\\views\\upload\\classPage\\category";
		//카테고리 별 파일저장 경로 설정
		String sCategory=(String) session.getAttribute("sCategory");
		session.removeAttribute("sCategory"); //세션에서 remove
		String uploadFolder= realPath; //저장경로
		if (sCategory.equals("메이크업")||sCategory.equals("스타일링")) {
			uploadFolder+="\\A_뷰티";
		}else if (sCategory.equals("영어")||sCategory.equals("일본어·중국어")||sCategory.equals("기타 외국어")) {
			uploadFolder+="\\B_외국어";
		}else if (sCategory.equals("댄스")||sCategory.equals("뮤직")) {
			uploadFolder+="\\C_댄스·뮤직";
		}else if (sCategory.equals("요리·음료")||sCategory.equals("공예·DIY")) {
			uploadFolder+="\\D_요리·공예";
		}else if (sCategory.equals("디자인")||sCategory.equals("영상")) {
			uploadFolder+="\\E_드로잉·디자인·영상";
		}
		
		for (int i = 0; i < 5; i++) {
			MultipartFile file=multi.getFile("classPhoto"+(i+1));
			if (file.getSize()!=0) {
				String fileRealName= file.getOriginalFilename(); //파일명을 얻어낼 수 있는 메서드
				long size= file.getSize(); //파일 사이즈
				System.out.println("파일명 : "+ fileRealName);
				System.out.println("용량크기(byte):"+ size);
				
				//서버에 저장할 파일이름 fileextension으로 확장자 명 구함
				String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
				
				//파일명 랜덤생성
				UUID uuid= UUID.randomUUID();
				System.out.println(uuid.toString());
				String[] uuids = uuid.toString().split("-"); 
				String uniqueName = classNum+"_"+uuids[0];
				System.out.println("classNum + 생성된 고유문자열"+ uniqueName);
				System.out.println("확장자명"+ fileExtension);
				//file
				File saveFile= new File(uploadFolder+"\\"+uniqueName+fileExtension); //uuid 적용
//				File saveFile= new File(uploadFolder+"\\"+fileRealName); //uuid 적용X
				//파일 업로드
				try {
					file.transferTo(saveFile);
					System.out.println("파일 업로드 성공");
					photoArr[i]= uniqueName+fileExtension;
				} catch (IllegalStateException | IOException e) {
					System.out.println("파일 업로드 실패");
					e.printStackTrace();
				}
			}//if문
		}//for문
		for (String s : photoArr) {
			System.out.println(s);
		}
		iDTO.setClassPhoto1(photoArr[0]);
		iDTO.setClassPhoto2(photoArr[1]);
		iDTO.setClassPhoto3(photoArr[2]);
		iDTO.setClassPhoto4(photoArr[3]);
		iDTO.setClassPhoto5(photoArr[4]);
		System.out.println(iDTO);
		//3. classImg 테이블에 저장하기
		int result3 =cService.uploadImg(iDTO);
		System.out.println("파일 저장:"+result3);
		if (result3 != 0) {
			session.setAttribute("classMesg", "클래스 등록 성공");
		}
		return "redirect:home2"; 
	}//ClassAdd
	
	@RequestMapping(value = "/tutorSearch")
	@ResponseBody
	public String tutorSearch(@RequestParam("userId") String tutorId) {
		//System.out.println("tutorId:"+tutorId);
		int num =cService.tutorSearch(tutorId); //튜터 등록 여부 확인
		//System.out.println("tutor result:"+num);
		String result="";
		if (num==1) {
			System.out.println("tutor 등록 확인");
			result="1";
		}else {
			result="0";
			System.out.println("tutor 등록X");
		}
		return result;
	}
	
	
}
