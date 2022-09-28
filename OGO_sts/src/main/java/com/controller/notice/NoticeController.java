package com.controller.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.notice.FAQ_DTO;
import com.dto.notice.NoticePageDTO;
import com.dto.notice.NoticeTableDTO;
import com.service.notice.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	NoticeService service;
	
	@RequestMapping(value = "/notice")
	public String notice(Model m, String curpage) {
		NoticePageDTO Pdto = new NoticePageDTO();
		String curPage = curpage;	//현체페이지 데이터 파싱
		if (curPage == null) { curPage = "1"; }	//처음 들어왔을 경우 1로 지정
		Pdto = service.getNotice(curPage);
		//System.out.println(Pdto);
		
		m.addAttribute("Pdto", Pdto);
		
		
		List<FAQ_DTO> FAQdto = service.selectAllFAQ();
		//System.out.println(FAQdto);//faq 정보 가져오기
		m.addAttribute("FAQdto",FAQdto);
		
		return"NoticeMain";
	}
	
	@RequestMapping(value = "/noticeContent")
	public ModelAndView noticeContent(@RequestParam("nNum") String nNum) {
		//System.out.println(nNum);//넘어온 고유 페이지 번호 확인
		NoticeTableDTO dto = service.selectContent(nNum);
		//System.out.println(dto); //가져온 정보 확인
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("NoticeDTO", dto); 
		mav.setViewName("NoticeContent"); 
		return mav;
	}
	
	
}//end