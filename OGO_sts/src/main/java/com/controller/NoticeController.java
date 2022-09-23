package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeController {

	@RequestMapping(value = "/notice")
	public String name() {
		return"notice_faq/NoticeTable";
	}
}