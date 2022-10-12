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

	public List<classlistDTO> selectall() {
		List<classlistDTO> list = template.selectList("classlistMapper.selectall");
		return list;
	}

	public List<classlistDTO> selectcate(String subcategory) {
		List<classlistDTO> list = template.selectList("classlistMapper.selectcate", subcategory);
		return list;
	}

}
