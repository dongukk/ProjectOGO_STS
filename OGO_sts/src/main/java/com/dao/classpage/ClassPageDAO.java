package com.dao.classpage;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.classpage.ClassDTO;
import com.dto.classpage.ClassImgDTO;

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

	public ClassImgDTO getImage(int classNum) {
		ClassImgDTO imgDTO=template.selectOne("ClassMapper.getImage", classNum);
		return imgDTO;
	}

	public int searchClassName(HashMap<String, Object> classMap) {
		int num=template.selectOne("ClassMapper.searchClassName", classMap);
		return num;
	}

	public int classOpen(ClassDTO cDTO) {
		int num=template.insert("ClassMapper.classOpen", cDTO);
		return num;
	}

	public int searchClassNum(HashMap<String, String> classMap) {
		int classNum=template.selectOne("ClassMapper.searchClassNum", classMap);
		return classNum;
	}

	public int uploadImg(ClassImgDTO iDTO) {
		int num =template.insert("ClassImgMapper.uploadImg", iDTO);
		return num;
	}

	public String getTintroduce(String userId) {
		String tintroduce=template.selectOne("ClassMapper.getTintroduce", userId);
		return tintroduce;
	}

	public int tutorSearch(String tutorId) {
		int result=template.selectOne("ClassMapper.tutorSearch", tutorId);
		return result;
	}
	
	
}
