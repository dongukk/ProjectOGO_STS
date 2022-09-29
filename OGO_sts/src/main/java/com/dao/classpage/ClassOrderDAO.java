package com.dao.classpage;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.classpage.ClassOrderDTO;

@Repository
public class ClassOrderDAO {
	@Autowired
	SqlSessionTemplate template;

	public int findOrder(ClassOrderDTO prevDTO) {
		int num=template.selectOne("ClassOrderMapper.findOrder", prevDTO);
		return num;
	}

	public int classOrder(ClassOrderDTO orderDTO) {
		int num=template.insert("ClassOrderMapper.classOrder", orderDTO);
		return num;
	}
	
}
