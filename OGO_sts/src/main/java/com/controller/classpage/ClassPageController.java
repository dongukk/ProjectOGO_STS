package com.controller.classpage;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dto.classpage.ClassDTO;
import com.service.classpage.ClassPageService;
import com.service.classpage.ContentService;

@Controller
public class ClassPageController {
	@Autowired
	ClassPageService classService;
	@Autowired
	ContentService conService;
	
	@RequestMapping(value = "/ClassPage")
	public ModelAndView classPage() {
		ModelAndView mav= new ModelAndView();
		int classNum= 221; //나중에 클래스 Num 받기
		//로그인 세션 받기
		
		//클래스 정보
		ClassDTO cDTO=classService.selectClass(221);
		
		//튜터 닉네임
		String tutorId = cDTO.getUserId();
		String nickName = classService.selectNickName(tutorId);
		
		//튜터 프로필 이미지
		String tutorProfile=classService.userProfilePhoto(tutorId);
			//System.out.println(tutorId+" tutorProfile: "+tutorProfile);
		
		//클래스소개,튜터소개,일정장소,유의사항,공지사항
		HashMap classContents=conService.selectContent(classNum);
		//System.out.println(classContents);
		
		//찜
		String userId="";
		
		
		mav.addObject("classDTO", cDTO); //classDTO 
		mav.addObject("nickName", nickName); //튜터 닉네임
		mav.addObject("tutorProfile", tutorProfile); //튜터 프로필 이미지
		mav.addObject("classContents", classContents); //클래스 contents
		
		mav.setViewName("ClassPage"); //view 페이지 
		return mav;
	}
	
	
}
