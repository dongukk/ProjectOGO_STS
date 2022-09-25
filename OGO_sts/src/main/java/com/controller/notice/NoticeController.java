package com.controller.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.notice.FAQ_DTO;
import com.dto.notice.NoticeTableDTO;
import com.service.notice.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	NoticeService service;
	
	@RequestMapping(value = "/notice")
	public String notice(Model m) {
		List<NoticeTableDTO> list= service.getNTdto();  
		m.addAttribute("NTdtoList", list);
		
		List<FAQ_DTO> FAQdto = service.selectAllFAQ();
		System.out.println(FAQdto);//faq 정보 가져오기
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