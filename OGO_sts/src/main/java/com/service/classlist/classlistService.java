package com.service.classlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.classlist.classlistDAO;
import com.dto.classlist.classlistDTO;

@Service
public class classlistService {
	@Autowired
	classlistDAO dao;

	public List<classlistDTO> selectall() {
		List<classlistDTO> list=dao.selectall();
		return list;
	}

	public List<classlistDTO> selectcate(String subcategory) { /*classlistDTO가 담긴 selectcate라는 변수명의 List를 반환할거임-String subcategory를 받아라!*/
		
		List<classlistDTO> list = dao.selectcate(subcategory);/*dao.안에 selectcate 함수를 실행시키면서 subcategory 가져가라!*/
		
		return list;
	}

	
}