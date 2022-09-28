package com.controller.classpage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.classpage.ClassOrderDTO;
import com.dto.member.MemberDTO;
import com.service.classpage.ClassOrderService;

@Controller
public class ClassOrderController {
	@Autowired
	ClassOrderService oService;
	
	//클래스 신청
	@RequestMapping(value = "/ClassOrder", produces = "application/text;charset=utf8")
	@ResponseBody
	public String ClassOrder(ClassOrderDTO orderDTO, HttpSession session) {
		System.out.println(orderDTO);
		//클래스 신청한 유저id
		MemberDTO mDTO=(MemberDTO) session.getAttribute("login");
		String userId=mDTO.getUserId();
		
		//오늘날짜구하기
		LocalDate nowD =LocalDate.now();
		DateTimeFormatter dateFormatter=DateTimeFormatter.ofPattern("yyMMdd");
		String today= nowD.format(dateFormatter);
		LocalTime nowT =LocalTime.now();
		DateTimeFormatter timeFormatter=DateTimeFormatter.ofPattern("HH");
		String time= nowT.format(timeFormatter);
		
		//주문번호 orderNum
		int idIndex =userId.indexOf("@");
		String orderUserId=userId;
		if (idIndex > -1) {//userId에 @가 포함된 경우
			orderUserId=userId.substring(0, idIndex);//@앞부분까지만 저장
		}
		int classNum= orderDTO.getClassNum();
		String orderNum= today+time+classNum+orderUserId;
		session.setAttribute("orderNum", orderNum); //세션에 주문번호 저장
		
		//유저가 이전에 같은 클래스 신청한 적 있는지 검사
		ClassOrderDTO prevDTO= new ClassOrderDTO();
		prevDTO.setClassNum(classNum);
		prevDTO.setUserId(userId);
		int findResult=oService.findOrder(prevDTO);
		  System.out.println("findResult: "+findResult);
		
		String mesg="";
		if (findResult > 0) { //이전에 신청한 적이 있음
			mesg= "이전에 수강한 클래스입니다. 다른 클래스를 신청해주세요";
		}else { //해당 클래스를 이전에 신청한 적이 없는 경우
			//classOrder에 insert
			orderDTO.setOrderNum(orderNum);
			orderDTO.setUserId(userId);
			orderDTO.setOrderStatus("결제 대기중");
			//System.out.println(orderDTO);
			int result = oService.classOrder(orderDTO);
			System.out.println("classOrder insert 성공:"+result);
			mesg="성공";
		}
		return mesg;
	}
}
