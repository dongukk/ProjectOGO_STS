//package com.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.dto.MainDTO;
//import com.service.MainService;
//
//@Controller
//public class mainController {
//	@Autowired
//	MainService service;
//	
//	@RequestMapping(value = "/main")
//	public String main(HttpServletRequest request) {
//		request.setAttribute("hello", "안녕하세요!");
//		
//		List<MainDTO> list = service.selectAll();
//		System.out.println(list);
//		request.setAttribute("list", list);
//		
//		return "main";
//	}
//	
//}
