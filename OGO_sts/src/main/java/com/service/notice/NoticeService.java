package com.service.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.notice.NoticeDAO;
import com.dto.notice.FAQ_DTO;
import com.dto.notice.NoticeTableDTO;

@Service
public class NoticeService {
	@Autowired
	NoticeDAO dao;

	public List<NoticeTableDTO> getNTdto() {
		return dao.getNTdto();
	}

	public NoticeTableDTO selectContent(String nNum) {
		return dao.selectContent(nNum);
	}

	public List<FAQ_DTO> selectAllFAQ() {
		return dao.selectAllFAQ();
	}

	

	
}
