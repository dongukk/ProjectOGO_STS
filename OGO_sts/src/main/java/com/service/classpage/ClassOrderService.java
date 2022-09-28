package com.service.classpage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.classpage.ClassOrderDAO;
import com.dto.classpage.ClassOrderDTO;

@Service
public class ClassOrderService {
	@Autowired
	ClassOrderDAO dao;

	public int findOrder(ClassOrderDTO prevDTO) {
		return dao.findOrder(prevDTO);
	}

	public int classOrder(ClassOrderDTO orderDTO) {
		return dao.classOrder(orderDTO);
	}
	
	
}
