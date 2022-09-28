package com.service.classpage;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.classpage.HeartDAO;

@Service
public class HeartService {
	@Autowired
	HeartDAO dao;

	public int heartSearch(HashMap<String, Object> heartData) {
		return dao.heartSearch(heartData);
	}

	public int heartCount(int classNum) {
		return dao.heartCount(classNum);
	}

	public int heartInsert(HashMap<String, Object> heartData) {
		return dao.heartInsert(heartData);
	}

	public int heartdelete(HashMap<String, Object> heartData) {
		return dao.heartdelete(heartData);
	}
}
