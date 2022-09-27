package com.dao.classpage;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.classpage.ClassDTO;

@Repository
public class ClassPageDAO {
	@Autowired
	SqlSessionTemplate template;
	
	public ClassDTO selectClass(int classNum) {
		ClassDTO cDTO= template.selectOne("ClassMapper.selectClass", classNum);
		return cDTO;
	}

	public String selectNickName(String tutorId) {
		String nickName=template.selectOne("ClassMapper.selectNickName", tutorId);
		return nickName;
	}

	public String userProfilePhoto(String tutorId) {
		String tutorProfile=template.selectOne("ClassMapper.userProfilePhoto", tutorId);
		return tutorProfile;
	}
	
	
}
