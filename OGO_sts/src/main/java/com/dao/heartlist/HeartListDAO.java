package com.dao.heartlist;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.heartlist.HeartListDTO;

@Repository
public class HeartListDAO {
	

	@Autowired
	SqlSessionTemplate template;


	public List<HeartListDTO> heartList(String userid) {
		return template.selectList("HeartMapper.heartList", userid);
	}
	
	public void heartlistDel(int num) {
		template.delete("HeartMapper.heartlistDel", num);
		
	}


	public void heartlistDelAll(List<String> list) {
		template.delete("HeartMapper.heartlistDelAll", list);
	}

}
