package com.service.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.member.MemberDAO;
import com.dto.member.MemberDTO;
import com.dto.member.PageDTO;

@Service
public class MemberService {
	@Autowired
	MemberDAO dao;

	public MemberDTO login(Map<String, String> map) {
		MemberDTO dto = dao.login(map);
		return dto;
	}

	public String idCheck(String userId) {
		String n = dao.idCheck(userId);
		return n;
	}

	public String nicknameCheck(String nickname) {
		String n = dao.nicknameCheck(nickname);
		return n;
	}

	public int memberAdd(MemberDTO dto) {
		int n = dao.memberAdd(dto);
		return n;
	}

	public PageDTO search(String searchName, String searchValue, int curPage) {
		HashMap<String, String> map = new HashMap<>();
		map.put("searchName", searchName);
		map.put("searchValue", searchValue);
		
		PageDTO pDTO = dao.search(map, curPage);	// map:검색결과, 최초 실행시curPage = 1
		
		return pDTO;
	}

	public int deleteAll(List<String> list) {
		int n = dao.deleteAll(list);
		return n;
	}

	public int delete(String userId) {
		int n = dao.delete(userId);
		return n;
	}

	public MemberDTO findId(HashMap<String, String> map) {
		MemberDTO dto = dao.findId(map);
		return dto;
	}

	public MemberDTO findPw(HashMap<String, String> map) {
		MemberDTO dto = dao.findPw(map);
		return dto;
	}

	public int newPw(HashMap<String, String> map) {
		int n=dao.newPw(map);
		return n;
	} 

	
}
