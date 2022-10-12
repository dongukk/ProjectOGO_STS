package com.dao.tutor;

import com.dto.tutor.TutorDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TutorDAO {

	@Autowired
	SqlSessionTemplate template;


	public int insertTutor(TutorDTO tutorDTO) {
		System.out.println(tutorDTO);
		return template.insert("TutorMapper.insertTutor", tutorDTO);
	}



}
