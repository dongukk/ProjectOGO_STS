package com.service.tutor;


import com.dao.tutor.TutorDAO;
import com.dto.tutor.TutorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class TutorService {


	private final String savePath = "C:\\eclipse\\file";
	private final TutorDAO tutorDAO;


	@Autowired
	public TutorService(TutorDAO tutorDAO) {
		this.tutorDAO = tutorDAO;
	}


	public int createTutor(TutorDTO dto) {
		return tutorDAO.insertTutor(dto);
	}

	public void storeFile(MultipartFile tutorimg, MultipartFile tcertificate) throws IOException {
		File file = new File(savePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		tutorimg.transferTo(new File(savePath+File.separator+tutorimg.getOriginalFilename()));
		tcertificate.transferTo(new File(savePath+File.separator+tcertificate.getOriginalFilename()));
	}
	
	
}
