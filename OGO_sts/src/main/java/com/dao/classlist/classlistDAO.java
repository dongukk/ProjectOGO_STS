package com.dao.classlist;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.classlist.classlistDTO;

@Repository
public class classlistDAO {
	@Autowired
	SqlSessionTemplate template;

	public List<classlistDTO> selectcate(String subcategory) {
		List<classlistDTO> list = template.selectList("classlistMapper.selectcate", subcategory);
		return list;
	}

	public List<classlistDTO> selectallnew(String desc) {
		return template.selectList("classlistMapper.selectallnew",desc);
	}

	public List<classlistDTO> selectallA() {
		return template.selectList("classlistMapper.selectallA");
	}
	
	public List<classlistDTO> selectallD() {
		return template.selectList("classlistMapper.selectallD");
	}

}
