package com.controller.classpage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.service.classpage.ClassPageService;

@Controller
public class ClassPageController {
	@Autowired
	ClassPageService cService;
	
	
}
