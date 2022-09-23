package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.MainDTO;

@Repository
public class MainDAO {
	@Autowired
	SqlSessionTemplate template;

	public List<MainDTO> selectAll() {
		return template.selectList("MainMapper.selectAll");
	}

}
