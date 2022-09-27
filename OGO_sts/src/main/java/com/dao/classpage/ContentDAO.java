package com.dao.classpage;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContentDAO {
	@Autowired
	SqlSessionTemplate template;

	public HashMap selectContent(int classNum) {
		HashMap con_class =template.selectOne("ContentMapper.selectContent", classNum);
		return con_class;
	}

}
