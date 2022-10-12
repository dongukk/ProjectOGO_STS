package com.controller.classpage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.classpage.ClassDTO;
import com.dto.comment.ClassCommentDTO;
import com.dto.member.MemberDTO;
import com.service.comment.ClassCommentService;

@Controller
public class ClassCommentController {
	@Autowired
	ClassCommentService service;
	
	
	//comment Insert
	@RequestMapping(value = "/loginCheck/comment_create")
	public String comment_create(String cmttextarea, HttpSession session) { //리뷰 생성 => 1.데이터 받기(textarea, classNum, userid)+dto전달 // 3.cmtadd로 같이 보내기 
		System.out.println("cmttextarea : "+ cmttextarea);
		ClassDTO Cdto = (ClassDTO) session.getAttribute("classDTO");
		MemberDTO Mdto =(MemberDTO) session.getAttribute("login");
		
		
		int classnum =  Cdto.getClassNum();
		String userid = Mdto.getUserId();
		String cmtnotice = cmttextarea;
		
		ClassCommentDTO cmt_dto = new ClassCommentDTO();
		cmt_dto.setClassnum(classnum);
		cmt_dto.setUserid(userid);
		cmt_dto.setComment_notice(cmttextarea);
		
		System.out.println("--------------------"+cmt_dto);
		
		service.cmtAdd(cmt_dto);
		
		
				
		return "redirect: ../ClassPage?listNum="+classnum;
	}

	
	@RequestMapping(value = "/loginCheck/comment_update")
	public String comment_update(String cmttextarea2, HttpSession session) { //리뷰 생성 => 1.데이터 받기(textarea, classNum, userid)+dto전달 // 3.cmtadd로 같이 보내기 
		System.out.println("cmttextarea : "+ cmttextarea2);
		ClassDTO Cdto = (ClassDTO) session.getAttribute("classDTO");
		MemberDTO Mdto =(MemberDTO) session.getAttribute("login");
		
		
		int classnum = Cdto.getClassNum();
		String userid = Mdto.getUserId();
		String cmtnotice = cmttextarea2;
		
		ClassCommentDTO cmt_dto = new ClassCommentDTO();
		cmt_dto.setClassnum(classnum);
		cmt_dto.setUserid(userid);
		cmt_dto.setComment_notice(cmttextarea2);
		
		System.out.println("--------------------"+cmt_dto);
		
		service.cmtUpdate(cmt_dto);
		
				
		/* return "redirect: ../ClassPage"; */
		return "redirect: ../ClassPage?listNum="+classnum;
	}
	
	
	@RequestMapping(value = "/loginCheck/comment_delete")
	public String comment_update(HttpSession session) { //리뷰 생성 => 1.데이터 받기(textarea, classNum, userid)+dto전달 // 3.cmtadd로 같이 보내기 
		ClassDTO Cdto = (ClassDTO) session.getAttribute("classDTO");
		MemberDTO Mdto =(MemberDTO) session.getAttribute("login");
		
		
		int classnum = Cdto.getClassNum();
		String userid = Mdto.getUserId();
		
		ClassCommentDTO cmt_dto = new ClassCommentDTO();
		cmt_dto.setClassnum(classnum);
		cmt_dto.setUserid(userid);
		
		System.out.println("--------------------"+cmt_dto);
		
		service.cmtDelete(cmt_dto);
		
				
		return "redirect: ../ClassPage?listNum="+classnum;
	}
	
	
	
}//end