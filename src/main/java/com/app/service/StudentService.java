package com.app.service;

import com.app.DTO.StudentRequestDTO;
import com.app.DTO.StudentRespDTO;
import com.app.Dao.StudentDao;

public interface StudentService {
	String addStudent(StudentRequestDTO studentRequestDTO);
	StudentRespDTO getStudent(String name);
	String cancelAdmission(Long id);
}
