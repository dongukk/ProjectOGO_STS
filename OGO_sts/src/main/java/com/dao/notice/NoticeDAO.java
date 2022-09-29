package com.dao.notice;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.notice.FAQ_DTO;
import com.dto.notice.NoticePageDTO;
import com.dto.notice.NoticeTableDTO;

@Repository
public class NoticeDAO {
	@Autowired
	SqlSessionTemplate template;

	

	public NoticeTableDTO selectContent(String nNum) {
		return template.selectOne("NoticeMapper.selectContent",nNum);
	}

	public List<FAQ_DTO> selectAllFAQ() {
		return template.selectList("NoticeMapper.selectAllFAQ");
	}

	public NoticePageDTO getNotice(String curPage) {
		NoticePageDTO Pdto = new NoticePageDTO();
		int perPage = Pdto.getPerPage();
		int offset = (Integer.parseInt(curPage) - 1) * perPage;
		
		List<NoticeTableDTO> list =template.selectList( "NoticeMapper.getNoticeList", null , new RowBounds(offset,perPage) );
		
		Pdto.setCurPage(curPage);
		Pdto.setList(list);
		Pdto.setTotalCount( totalCount() );
		return Pdto;
	}
	
	public int totalCount() {
		int result = template.selectOne("NoticeMapper.totalCount");
		return result;
	}

	public void NoticeDelete(int nNum) {
		int num =template.delete("NoticeMapper.NoticeDelete",nNum);
		System.out.println("삭제된 개수: "+num);
		
	}

	public void NoticeUpdate2(NoticeTableDTO dto) {
		int num =template.update("NoticeMapper.NoticeUpdate2",dto);
		System.out.println("업데이트 된 개수 : "+ num);
	}

	public void CreateNotice(NoticeTableDTO dto) {
		int num = template.insert("NoticeMapper.CreateNotice",dto);
		System.out.println("생성된 갯수 : "+num);
	}
	
	
}
