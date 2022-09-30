package com.controller.classpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClassCreateController {
	
	@RequestMapping(value = "/loginCheck/ClassCreate")
	public String classCreate() {
		
		return "redirect:../ClassCreateForm";
	}

}
