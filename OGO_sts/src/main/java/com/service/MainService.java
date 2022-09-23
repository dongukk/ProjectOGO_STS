package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MainDAO;
import com.dto.MainDTO;

@Service
public class MainService {
	@Autowired
	MainDAO dao;

	public List<MainDTO> selectAll() {
		return dao.selectAll();
	}
	
	
}
