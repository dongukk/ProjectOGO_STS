package com.dao.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.member.MemberDTO;
import com.dto.member.PageDTO;

@Repository
public class MemberDAO {
	@Autowired
	SqlSessionTemplate template;

	public MemberDTO login(Map<String, String> map) {
		MemberDTO dto = template.selectOne("MemberMapper.login", map);
		return dto;
	}

	public String idCheck(String userId) {
		String n = template.selectOne("MemberMapper.idCheck", userId);
		return n;
	}

	public String nicknameCheck(String nickname) {
		String n = template.selectOne("MemberMapper.nicknameCheck", nickname);
		return n;
	}

	public int memberAdd(MemberDTO dto) {
		int n = template.insert("MemberMapper.memberAdd", dto);
		return n;
	}

	private int totalCount(HashMap<String, String> map) {
		 int n = template.selectOne("MemberMapper.totalCount",map);
		 System.out.println("totalCount : "+n);
		 return n;
	}
	
	public PageDTO search(HashMap<String, String> map, int curPage) {
		PageDTO pDTO = new PageDTO();			// perPage = 2
		int perPage = pDTO.getPerPage();   		//한페이지 10개씩 
		int offset = (curPage - 1) * perPage; 	// 최초curPage=1, offset= 1페이지=0, 2페이지면 =2, 3페이지면 =4
		System.out.println("map : "+map+"curPage : "+curPage);
		
		List<MemberDTO> list =  template.selectList("MemberMapper.search" , map , new RowBounds(offset, perPage));
		//레코드 시작 번호, 읽어올 갯수 
		System.out.println("list : "+list);
		pDTO.setCurPage(curPage);//현재 페이지번호 1
		pDTO.setList(list);//페이지 에 해당 데이터 (0, 1)
		pDTO.setTotalCount(totalCount(map));//전체 레코드 갯수 저장 
		
		return pDTO;
	}

	public int deleteAll(List<String> list) {
	   	int n = template.delete("MemberMapper.deleteByAllMember", list);
		return n;
	}

	public int delete(String userId) {
		int n = template.delete("MemberMapper.deleteByMember", userId);
		return n;
	}

	public MemberDTO findId(HashMap<String, String> map) {
		MemberDTO dto = template.selectOne("MemberMapper.findId", map);
		return dto;
	}

	public MemberDTO findPw(HashMap<String, String> map) {
		MemberDTO dto = template.selectOne("MemberMapper.findPw", map);
		return dto;
	}

	public int newPw(HashMap<String, String> map) {
		int n = template.update("MemberMapper.newPw", map); 
		return n; 
	}

	public String fileName(String userId) {
		String fileName = template.selectOne("MemberMapper.fileName", userId);
		return fileName;
	}


}
