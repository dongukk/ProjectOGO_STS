package com.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.member.MemberDTO;
import com.dto.notice.FAQ_DTO;
import com.dto.notice.NoticePageDTO;
import com.dto.notice.NoticeTableDTO;
import com.service.notice.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	NoticeService service;

	@RequestMapping(value = "/notice")
	public String notice(Model m, String curpage, HttpSession session) {
		NoticePageDTO Pdto = new NoticePageDTO();
		String curPage = curpage; // 현체페이지 데이터 파싱
		if (curPage == null) {
			curPage = "1";
		} // 처음 들어왔을 경우 1로 지정
		Pdto = service.getNotice(curPage);
		// System.out.println(Pdto);

		m.addAttribute("Pdto", Pdto);

		List<FAQ_DTO> FAQdto = service.selectAllFAQ();
		// System.out.println(FAQdto);//faq 정보 가져오기
		m.addAttribute("FAQdto", FAQdto);
		
		return "NoticeMain";
	}

	@RequestMapping(value = "/noticeContent")
	public ModelAndView noticeContent(@RequestParam("nNum") String nNum) {
		// System.out.println(nNum);//넘어온 고유 페이지 번호 확인
		NoticeTableDTO dto = service.selectContent(nNum);
		// System.out.println(dto); //가져온 정보 확인

		ModelAndView mav = new ModelAndView();
		mav.addObject("NoticeDTO", dto);
		mav.setViewName("NoticeContent");
		return mav;
	}

	@RequestMapping(value = "/loginCheck/NoticeDelete")
	public String NoticeDelete(int nNum) {
		service.NoticeDelete(nNum);
		return "redirect: ../notice";
	}

	
	/* ModelAndView, Model, request는 redirect시 정보를 누락 시키므로 RedirectAttrivutes를 사용!
	 * @RequestMapping(value = "/loginCheck/NoticeUpdate") 
	 * public ModelAndView NoticeUpdate(int nNum) { 
	 * NoticeTableDTO dto = service.selectContent(""+nNum);
	 * 
	 * ModelAndView mav = new ModelAndView(); 
	 * mav.addObject("dto",dto);
	 * mav.setViewName("loginCheck/NoticeUpdate"); 
	 * return mav; 
	 * }
	 */
	 

	@RequestMapping(value = "/loginCheck/NoticeUpdate1")
	public String cartList(int nNum, RedirectAttributes attr, HttpSession session) {
		NoticeTableDTO dto = service.selectContent("" + nNum);
		attr.addFlashAttribute("dto", dto);// 리다이렉트시 데이터 유지
		return "redirect:../loginCheck/NoticeUpdateView"; // servlet-context에 등록
	}

	@RequestMapping(value = "/loginCheck/NoticeUpdateView") //loginCheck를 위해 한번 NoticeUpdate1을 한번 더 실행
	public String noticeUpdateView() {
		return "NoticeUpdate";
	}

	@RequestMapping(value = "/loginCheck/NoticeUpdate2")
	public String NoticeUpdate2(NoticeTableDTO dto, HttpSession session) {
		MemberDTO Mdto = (MemberDTO) session.getAttribute("login");
		dto.setNickName(Mdto.getUserId()); // userid를 사용해야 해서 nickName 부분을 userid로 바꿈
		service.NoticeUpdate2(dto);
		return "redirect:../noticeContent?nNum=" + dto.getnNum();
	}
	
	@RequestMapping(value = "/loginCheck/NoticeCreate1")
	public String CreateNotice1() {
		return "NoticeCreate";
	}
	
	@RequestMapping(value = "/loginCheck/NoticeCreate2")
	public String CreateNotice2(NoticeTableDTO dto, HttpSession session) {
		MemberDTO Mdto =(MemberDTO) session.getAttribute("login");
		dto.setNickName(Mdto.getUserId()); //nickname이지만 mapper에선 userid를 사용하기에 userid를 넣어줌
		service.CreateNotice(dto);
		return "redirect:../notice";
	}
	

}// end