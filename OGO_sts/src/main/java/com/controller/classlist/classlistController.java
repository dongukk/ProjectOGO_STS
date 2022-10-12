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

	@RequestMapping(value = "/home2")//home2로 접근, 밑에 함수로 감
	//@ResponseBody  //return 값으로 test
	public String home2(String subcategory, Model m) { 
		
		if (subcategory == null) {//subcategory가 널값일때 밑에 적용
			
			List<classlistDTO> list = service.selectall();//service-dao-mapper 데이터 가져오는 과정 list에 담겨있음
			m.addAttribute("classlist", list);//classlist로 변수명, list의 데이터를 m이 들고 home2로 따라가서 ${}실행
		
		} else if (subcategory != null) {
			/* System.out.println(subcategory); */ //카테고리를 잘 가져왔는지 확인
			
			List<classlistDTO> list = service.selectcate(subcategory);
			m.addAttribute("classlist", list);
		}
		
		return "home2";
	}
}