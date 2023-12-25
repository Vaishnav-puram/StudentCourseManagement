package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.CourseResDTO;
import com.app.DTO.StudentRespDTO;
import com.app.Dao.CourseDao;
import com.app.Dao.StudentDao;
import com.app.Pojos.Course;

@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private CourseDao courseDao;

	@Override
	public CourseResDTO getCourse(Long id) {
		Course c=courseDao.findById(id).orElseThrow();
		List<StudentRespDTO> studentList=new ArrayList<>();
		c.getStudents().forEach(s->{
			StudentRespDTO studentRespDTO=new StudentRespDTO();
			studentRespDTO.setFirstName(s.getFirstName());
			studentRespDTO.setLastName(s.getLastName());
			studentRespDTO.setEmail(s.getEmail());
			studentRespDTO.setScoreObtained(s.getScoreObtained());
			studentRespDTO.setCourseTitle(s.getCourse().getCourse());
			studentList.add(studentRespDTO);
		});
		CourseResDTO courseResDTO=new CourseResDTO();
		courseResDTO.setCourse(c.getCourse());
		courseResDTO.setStartDate(c.getStartDate());
		courseResDTO.setEndDate(c.getEndDate());
		courseResDTO.setMinScore(c.getMinScore());
		courseResDTO.setFees(c.getFees());
		courseResDTO.setStudents(studentList);
		return courseResDTO;
		
	}

	@Override
	public String updateFee(Long id,int offSet) {
		// TODO Auto-generated method stub
		Course c=courseDao.findById(id).orElseThrow();
		c.setFees(c.getFees()+offSet);
		courseDao.save(c);
		return "fees updated successfully";
	}

}
