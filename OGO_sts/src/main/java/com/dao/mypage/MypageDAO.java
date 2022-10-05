package com.dao.mypage;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MypageDAO {
	@Autowired
	SqlSessionTemplate template;

	public void ChangePW(String userid, String passwd) {
		Map<String, String> CPW = new HashMap<String, String>();
		CPW.put("userid", userid);
		CPW.put("passwd", passwd);
		int num = template.update("MyPageMapper.ChangePW",CPW);	
		System.out.println("수정된 갯수 : "+num);
	}

	public int CheckID(String userid) {
		int num =template.selectOne("CheckID",userid);
		System.out.println("id중복 개수:"+num);
		return num;
	}
	
	
	
	
	
	
	
}
