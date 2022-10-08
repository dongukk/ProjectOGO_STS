package com.service.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mypage.MypageDAO;
import com.dto.member.MemberDTO;

@Service
public class MypageService {
	@Autowired
	MypageDAO dao ;

	public void ChangePW(String userid, String passwd) {
		dao.ChangePW(userid, passwd);	
	}

	public String CheckID(String userid) {
		String ID = dao.CheckID(userid);
		return ID;
	}

	public void MemberUpdate(MemberDTO dto) {
		dao.MemberUpdate(dto);
	}
	
	
	
	
	
	
	
	
	
	
}
