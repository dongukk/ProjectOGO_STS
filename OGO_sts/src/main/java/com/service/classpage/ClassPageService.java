package com.service.classpage;

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

}
