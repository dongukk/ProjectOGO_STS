package com.controller.heartlist;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dto.heartlist.HeartListDTO;
import com.dto.member.MemberDTO;
import com.service.heartlist.HeartListService;

@Controller
public class HeartController {

	@Autowired
	private HeartListService heartListService;

    @GetMapping("/hearts")
    public String register(HttpSession session, Model model) {
		MemberDTO dto=(MemberDTO)session.getAttribute("login");
		String userid=dto.getUserId();
		List<HeartListDTO> list=heartListService.heartList(userid);
		model.addAttribute("list",list);
        return "/heartlist/heart_01";
    }
    
    @GetMapping("/hearts/{num}")
    public String heartlistDel(HttpSession session, Model model,@PathVariable int num) {
		MemberDTO dto=(MemberDTO)session.getAttribute("login");
		String userid=dto.getUserId();
		heartListService.heartlistDel(num);
        return "redirect:/hearts";
    }
    
    
    @GetMapping("/hearts/all/{nums}")
    public String heartlistDelAll(HttpSession session, Model model,@PathVariable("nums") String nums) {
		MemberDTO dto=(MemberDTO)session.getAttribute("login");
		String[] splits = nums.split(",");
		List<String> list= Arrays.asList(splits);
		heartListService.heartlistDelAll(list);
        return "redirect:/hearts";
    }
}
