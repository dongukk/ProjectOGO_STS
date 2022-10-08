package com.dao.mypage;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.member.MemberDTO;

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

	public String CheckID(String userid) {
		String ID =template.selectOne("MyPageMapper.CheckID",userid);
		System.out.println("중복id :"+ID);
		return ID ;
	}

	public void MemberUpdate(MemberDTO dto) {
		int num =template.update("MyPageMapper.MemberUpdate",dto);
		System.out.println("업데이트한 개수 "+num);
	}
	
	
	
	
	
	
	
}
