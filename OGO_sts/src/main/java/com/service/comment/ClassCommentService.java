package com.service.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.comment.ClassCommentDAO;
import com.dto.comment.ClassCommentDTO;
import com.dto.comment.ClassCommentPageDTO;


@Service
public class ClassCommentService {
	
	@Autowired
	ClassCommentDAO dao;
	
	public int cmtAdd(ClassCommentDTO cmt_dto) {
		int n = dao.cmtAdd(cmt_dto);
		return n;
	}
	
	
	public int cmtUpdate(ClassCommentDTO cmt_dto) {
		int n = dao.cmtUpdate(cmt_dto);
		return n;
	}
			
	public int cmtDelete(ClassCommentDTO cmt_dto) {
		int n = dao.cmtDelete(cmt_dto);
		return n;
	}
	
	public ClassCommentPageDTO viewPage(int curpage) {
		ClassCommentPageDTO dto = dao.viewPage(curpage);
		return dto;
	}


	

	
	
}//end class
