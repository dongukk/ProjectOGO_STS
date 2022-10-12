package com.controller.pay;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.pay.PayDTO;
import com.service.pay.PayService;

@Controller
public class PayController {
	@Autowired
	PayService service;
	
		
	@RequestMapping(value =  "PayMain", produces="application/json; charset=utf-8")
	@ResponseBody
	public String PayMain(HttpSession session) {
		String orderNum =(String) session.getAttribute("orderNum");
	 	PayDTO dto = service.selectOrder(orderNum);
	 	
		List<String> list = new ArrayList<>();
		list.add(dto.getSchedule1());
		list.add(dto.getSchedule2());
		list.add(dto.getSchedule3());
		list.add(dto.getSchedule4());
		list.add(dto.getSchedule5());
		list.add(dto.getSchedule6());
		list.add(dto.getSchedule7());
		list.add(dto.getSchedule8());
		list.add(dto.getSchedule9());
		list.add(dto.getSchedule10());		
		
		
		String date = "";
		for (int i = 0; i < list.size(); i++) {
			if ( list.get(i) !=null) {
				if (i != list.size()-1) {
					date += list.get(i)+",";
				}
			}
		}
	 	
		String arraydate[]= date.split(",");
		int countDate = arraydate.length;
		
		System.out.println("사용할 정보 "+dto);
		
		String json = "{\"price\" : \"";
		json += dto.getPrice()+"\", \"PLACE\" : \"";
		json += dto.getPlace() +"\", \"CLASSNAME\" : \"";
		json += dto.getClassname()+"\", \"countDate\": \"";
		json += countDate+"\", \"customerName\" : \"";
		json += dto.getUsername()+"\", \"orderNum\" : \"";
		json += dto.getOrdernum();
		json += "\" }";
		
		
		return json;
	}
	
	@RequestMapping(value = "/PaySuccess")
	public String Cpayment(HttpSession session, Model m) {
		String orderNum =(String) session.getAttribute("orderNum");
		List<PayDTO> PayList = service.Cpayment(orderNum); 
		
		
		System.out.println("들어가기전 PayList : "+PayList);
		for (PayDTO payDTO : PayList) {
			List<String> SClist = new ArrayList<>();
			SClist.add(payDTO.getSchedule1());
			SClist.add(payDTO.getSchedule2());
			SClist.add(payDTO.getSchedule3());
			SClist.add(payDTO.getSchedule4());
			SClist.add(payDTO.getSchedule5());
			SClist.add(payDTO.getSchedule6());
			SClist.add(payDTO.getSchedule7());
			SClist.add(payDTO.getSchedule8());
			SClist.add(payDTO.getSchedule9());
			SClist.add(payDTO.getSchedule10());		
			
			String date = "";
			for (int i = 0; i < SClist.size(); i++) {
				if ( SClist.get(i) !=null) {
					if (i != SClist.size()-1) {
						date += SClist.get(i)+",";
					}
				}
						
				
			}//for
			
			date = date.substring(0,date.length()-1);
			System.out.println(date);
			
			payDTO.setAllschedule(date);

		}//for
		m.addAttribute("list",PayList);
		return "PaySuccess";
	}
	
	@RequestMapping(value = "/loginCheck/paymentlog")
	public String paymentlog(String userId, Model m) {
		List<PayDTO> PayList = service.getPlog(userId);
		
		for (PayDTO payDTO : PayList) {
			List<String> SClist = new ArrayList<>();
			SClist.add(payDTO.getSchedule1());
			SClist.add(payDTO.getSchedule2());
			SClist.add(payDTO.getSchedule3());
			SClist.add(payDTO.getSchedule4());
			SClist.add(payDTO.getSchedule5());
			SClist.add(payDTO.getSchedule6());
			SClist.add(payDTO.getSchedule7());
			SClist.add(payDTO.getSchedule8());
			SClist.add(payDTO.getSchedule9());
			SClist.add(payDTO.getSchedule10());		
			
			String date = "";
			for (int i = 0; i < SClist.size(); i++) {
				if ( SClist.get(i) !=null) {
					if (i != SClist.size()-1) {
						date += SClist.get(i)+",";
					}
				}
						
				
			}//for
			
			date = date.substring(0,date.length()-1);
			System.out.println(date);
			
			payDTO.setAllschedule(date);
		}
		m.addAttribute("list", PayList);
		return "paymentlog";
	}
	
}//controller