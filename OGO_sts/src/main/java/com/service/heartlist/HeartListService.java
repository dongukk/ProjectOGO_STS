package com.service.heartlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.heartlist.HeartListDAO;
import com.dto.heartlist.HeartListDTO;



@Service
public class HeartListService {

	@Autowired
	private HeartListDAO heartListDao;
	
	public List<HeartListDTO> heartList(String userid) {
		return heartListDao.heartList(userid);
	}
	
	public void heartlistDel(int num) {

		heartListDao.heartlistDel(num);
		
	}
	
	public void heartlistDelAll(List<String> list) {

		heartListDao.heartlistDelAll(list);
		
	}


	
}
