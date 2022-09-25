package com.dao.notice;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.notice.FAQ_DTO;
import com.dto.notice.NoticeTableDTO;

@Repository
public class NoticeDAO {
	@Autowired
	SqlSessionTemplate template;

	public List<NoticeTableDTO> getNTdto() {
		return template.selectList("NoticeMapper.getNTdto");
	}

	public NoticeTableDTO selectContent(String nNum) {
		return template.selectOne("NoticeMapper.selectContent",nNum);
	}

	public List<FAQ_DTO> selectAllFAQ() {
		return template.selectList("NoticeMapper.selectAllFAQ");
	}
	
}
