package com.controller.classpage;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.classpage.ClassDTO;
import com.dto.classpage.ClassImgDTO;
import com.dto.member.MemberDTO;
import com.service.classpage.ClassPageService;
import com.service.classpage.ContentService;
import com.service.classpage.HeartService;

@Controller
public class ClassPageController {
	@Autowired
	ClassPageService classService;
	@Autowired
	ContentService conService;
	@Autowired
	HeartService hService;
	
	@RequestMapping(value = "/ClassPage")
	public ModelAndView classPage(HttpSession session) {
		ModelAndView mav= new ModelAndView();
		int classNum= 202; //나중에 클래스 Num 받기
		//로그인 세션 받기
		MemberDTO mDTO = (MemberDTO) session.getAttribute("login");
		//클래스 정보
		ClassDTO cDTO=classService.selectClass(classNum);
		
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
		if (mDTO!=null) { //로그인 된 경우
			userId=mDTO.getUserId(); //유저 아이디
		}
		HashMap<String, Object> heartData= new HashMap<String, Object>();
		heartData.put("userId", userId);
		heartData.put("classNum", classNum);
		//클래스의 찜 여부 확인
		int num=hService.heartSearch(heartData); //해당 클래스가 찜 목록에 있는지 검사
		String heartYN= String.valueOf(num);
		//찜 개수 count
		int count=hService.heartCount(classNum);
		
		//이미지 불러오기
		ClassImgDTO imgDTO = classService.getImage(classNum);
		
		mav.addObject("classDTO", cDTO); //classDTO 
		mav.addObject("nickName", nickName); //튜터 닉네임
		mav.addObject("tutorProfile", tutorProfile); //튜터 프로필 이미지
		mav.addObject("classContents", classContents); //클래스 contents
		mav.addObject("heartYN", heartYN); //찜 여부 검사
		mav.addObject("heartCount", count); //찜 개수 count
		mav.addObject("imgDTO", imgDTO); //클래스 별 이미지
		
		//클래스 등록 페이지 테스트 위한 session
		session.setAttribute("classDTO", cDTO);
		
		mav.setViewName("ClassPage"); //view 페이지 
		return mav;
	}
	//찜 등록,해제
	@RequestMapping(value = "/HeartClick")
	@ResponseBody
	public String heartClick(@RequestParam("userId") String userId, 
			@RequestParam("classNum") int classNum, @RequestParam("heartYN") int heartYN) {
		System.out.println(userId+"\t"+classNum+"\t"+heartYN);
		//찜
		HashMap<String, Object> heartData= new HashMap<String, Object>();
		heartData.put("userId", userId);
		heartData.put("classNum", classNum);
			//클래스의 찜 여부 확인
		heartYN=hService.heartSearch(heartData); //값이 바뀐 경우 있으므로 다시한번 찜 여부 확인
		System.out.println("heartYN:"+heartYN);
		int num=0;
		String result=null;
		if (heartYN==0) { //찜 되어 있지 않은 경우 - heart에 insert
			num= hService.heartInsert(heartData);
			System.out.println(num);
			if (num==1) {
				System.out.println("heart insert 성공");
				heartYN=hService.heartSearch(heartData); //해당 클래스가 찜 목록에 있는지 다시 검사
				System.out.println("insert후 heartYN:"+heartYN);
				result="insert";
			}
		}else { //이미 찜 되어있는 경우 - heart에서 delete
			num= hService.heartdelete(heartData);
			if (num==1) {
				System.out.println("heart delete 성공");
				heartYN=hService.heartSearch(heartData); //해당 클래스가 찜 목록에 있는지 다시 검사
				System.out.println("delete후 heartYN:"+heartYN);
				result="delete";
			}
		}
		return result;
	}
	//찜 개수
	@RequestMapping(value = "/HeartCount")
	@ResponseBody
	public String heartCount(@RequestParam("classNum") int classNum) {
		//System.out.println("heartcount classnum:"+classNum);
		String count= String.valueOf(hService.heartCount(classNum));
				
		return count;
	}

	
	
}
