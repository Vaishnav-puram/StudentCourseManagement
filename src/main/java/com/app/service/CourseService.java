package com.app.service;

import com.app.DTO.CourseResDTO;

public interface CourseService {
	CourseResDTO getCourse(Long id);
	String updateFee(Long id,int offSet);
}
