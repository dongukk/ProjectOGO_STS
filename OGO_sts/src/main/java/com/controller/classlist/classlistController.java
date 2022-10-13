package com.controller.classlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.classlist.classlistDTO;
import com.service.classlist.classlistService;

@Controller
public class classlistController {
	@Autowired
	classlistService service;

	@SuppressWarnings("unused")
	@RequestMapping(value = "/home2")//home2로 접근, 밑에 함수로 감
	//@ResponseBody  //return 값으로 test
	public String home2(String subcategory, Model m, String mesg) { 
		
		String a = "desc";
		List<classlistDTO> list = service.selectallnew(a);
		System.out.println("new 와 처음"+list);
		m.addAttribute("classlist", list);
		
		if (subcategory == null && mesg != null) {//subcategory가 널값일때 밑에 적용
			System.out.println("카테고리 없을 때 : "+mesg);
			
			if (mesg.equals("new")) {
				list = service.selectallnew(a);
				System.out.println("new 와 처음"+list);
				m.addAttribute("classlist", list);
			}else if (mesg.equals("asc") ) {
				list = service.selectallA();
				System.out.println("low"+list);
				m.addAttribute("classlist", list);
			}else if(mesg.equals("desc") ) {
				list = service.selectallD();
				System.out.println("high"+list);
				m.addAttribute("classlist", list);
			}else {
				System.out.println("여기 오면 안됨");
			}
			
			/*
			 * List<classlistDTO> list = service.selectall();//service-dao-mapper 데이터 가져오는
			 * 과정 list에 담겨있음 m.addAttribute("classlist", list);//classlist로 변수명, list의 데이터를
			 * m이 들고 home2로 따라가서 ${}실행
			 */		
		} else if (subcategory != null) {
			System.out.println("카테고리 있을 때 : "+subcategory);//카테고리를 잘 가져왔는지 확인
			
			 list = service.selectcate(subcategory);
			m.addAttribute("classlist", list);
			
		}
		System.out.println("끝!!!!!");
		return "home2";
	}
}