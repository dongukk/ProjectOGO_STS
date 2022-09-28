package com.dao.classpage;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HeartDAO {
	@Autowired
	SqlSessionTemplate template;

	public int heartSearch(HashMap<String, Object> heartData) {
		int num =template.selectOne("HeartMapper.heartSearch", heartData);
		return num;
	}

	public int heartCount(int classNum) {
		int count = template.selectOne("HeartMapper.heartCount", classNum);
		return count;
	}

	public int heartInsert(HashMap<String, Object> heartData) {
		int num=template.insert("HeartMapper.heartInsert", heartData);
		return num;
	}

	public int heartdelete(HashMap<String, Object> heartData) {
		int num=template.delete("HeartMapper.heartdelete", heartData);
		return num;
	}
}
