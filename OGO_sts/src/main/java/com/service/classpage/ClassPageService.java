package com.service.classpage;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.classpage.ClassPageDAO;
import com.dto.classpage.ClassDTO;
import com.dto.classpage.ClassImgDTO;

@Service
public class ClassPageService {
	@Autowired
	ClassPageDAO dao;

	public ClassDTO selectClass(int classNum) {
		return dao.selectClass(classNum);
	}

	public String selectNickName(String tutorId) {
		return dao.selectNickName(tutorId);
	}

	public String userProfilePhoto(String tutorId) {
		return dao.userProfilePhoto(tutorId);
	}

	public ClassImgDTO getImage(int classNum) {
		return dao.getImage(classNum);
	}

	public int searchClassName(HashMap<String, Object> classMap) {
		return dao.searchClassName(classMap);
	}

	public int classOpen(ClassDTO cDTO) {
		return dao.classOpen(cDTO);
	}

	public int searchClassNum(HashMap<String, String> classMap) {
		return dao.searchClassNum(classMap);
	}

	public int uploadImg(ClassImgDTO iDTO) {
		return dao.uploadImg(iDTO);
	}

	public String getTintroduce(String userId) {
		return dao.getTintroduce(userId);
	}

	public int tutorSearch(String tutorId) {
		return dao.tutorSearch(tutorId);
	}

}
