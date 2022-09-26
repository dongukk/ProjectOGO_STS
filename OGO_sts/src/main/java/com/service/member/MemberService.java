package com.service.member;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.member.MemberDAO;
import com.dto.member.MemberDTO;

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

	
}
