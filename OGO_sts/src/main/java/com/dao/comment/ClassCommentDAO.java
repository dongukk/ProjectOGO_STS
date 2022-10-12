package com.dao.comment;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.comment.ClassCommentDTO;
import com.dto.comment.ClassCommentPageDTO;

@Repository
public class ClassCommentDAO {
	@Autowired
	SqlSessionTemplate template;
	

	public int cmtAdd(ClassCommentDTO cmt_dto) {
		return template.insert("ClassCommentMapper.cmtAdd", cmt_dto);
	}

	public int cmtUpdate(ClassCommentDTO cmt_dto) {
		return template.update("ClassCommentMapper.cmtUpdate",cmt_dto);
	}

	public int cmtDelete(ClassCommentDTO cmt_dto) {
		return template.delete("ClassCommentMapper.cmtDelete",cmt_dto);
	}

	public ClassCommentPageDTO viewPage(int curpage) {
		ClassCommentPageDTO cmtpagedto = new ClassCommentPageDTO();
		int perpage = cmtpagedto.getPerPage();
		int offset = (curpage - 1) * perpage; //index 번호
		
		
		List<ClassCommentDTO> listcmtdto = template.selectList("ClassCommentMapper.viewPage",null,new RowBounds(offset,perpage));
		System.out.println("dao: "+listcmtdto);
		cmtpagedto.setCurPage(curpage);
		cmtpagedto.setList(listcmtdto);
		cmtpagedto.setTotalPage( totalcount() );
		return cmtpagedto;
	}

	private int totalcount() {
		int total = template.selectOne("ClassCommentMapper.viewTotal");
		return total;
	}



	
	
	
}//end class
