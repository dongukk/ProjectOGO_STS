package com.controller.pay;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		list.add(dto.getSCHEDULE1());
		list.add(dto.getSCHEDULE2());
		list.add(dto.getSCHEDULE3());
		list.add(dto.getSCHEDULE4());
		list.add(dto.getSCHEDULE5());
		list.add(dto.getSCHEDULE6());
		list.add(dto.getSCHEDULE7());
		list.add(dto.getSCHEDULE8());
		list.add(dto.getSCHEDULE9());
		list.add(dto.getSCHEDULE10());		
		
		
		String date = "";
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null) {
				date += list.get(i)+",";
			}
		}
	 	
		String arraydate[]= date.split(",");
		int countDate = arraydate.length;
		
		System.out.println("사용할 정보 "+dto);
		
		String json = "{\"price\" : \"";
		json += dto.getPRICE()+"\", \"PLACE\" : \"";
		json += dto.getPLACE() +"\", \"CLASSNAME\" : \"";
		json += dto.getCLASSNAME()+"\", \"countDate\": \"";
		json += countDate+"\", \"customerName\" : \"";
		json += dto.getUSERNAME()+"\", \"orderNum\" : \"";
		json += dto.getORDERNUM();
		json += "\" }";
		
		
		return json;
	}
}
