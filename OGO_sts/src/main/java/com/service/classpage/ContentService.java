package com.service.classpage;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.classpage.ContentDAO;

@Service
public class ContentService {
	@Autowired
	ContentDAO dao;

	public HashMap selectContent(int classNum) {
		return dao.selectContent(classNum);
	}

	public int saveContent(HashMap<String, Object> contentMap) {
		return dao.saveContent(contentMap);
	}

	
}
