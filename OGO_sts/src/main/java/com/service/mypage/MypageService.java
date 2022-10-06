package com.service.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mypage.MypageDAO;

@Service
public class MypageService {
	@Autowired
	MypageDAO dao ;

	public void ChangePW(String userid, String passwd) {
		dao.ChangePW(userid, passwd);	
	}

	public int CheckID(String userid) {
		int ID = dao.CheckID(userid);
		return ID;
	}
	
	
	
	
	
	
	
	
	
	
}
