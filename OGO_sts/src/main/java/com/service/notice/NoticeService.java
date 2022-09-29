package com.service.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.notice.NoticeDAO;
import com.dto.notice.FAQ_DTO;
import com.dto.notice.NoticePageDTO;
import com.dto.notice.NoticeTableDTO;

@Service
public class NoticeService {
	@Autowired
	NoticeDAO dao;

	

	public NoticeTableDTO selectContent(String nNum) {
		return dao.selectContent(nNum);
	}

	public List<FAQ_DTO> selectAllFAQ() {
		return dao.selectAllFAQ();
	}

	public NoticePageDTO getNotice(String curPage) {
		return dao.getNotice(curPage);
	}

	public void NoticeDelete(int nNum) {
				dao.NoticeDelete(nNum);
	}

	public void NoticeUpdate2(NoticeTableDTO dto) {
				dao.NoticeUpdate2(dto);
		
	}

	public void CreateNotice(NoticeTableDTO dto) {
				dao.CreateNotice(dto);
		
	}

	

	
}
