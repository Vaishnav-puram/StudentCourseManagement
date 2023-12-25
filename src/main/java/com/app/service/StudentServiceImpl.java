package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.StudentRequestDTO;
import com.app.DTO.StudentRespDTO;
import com.app.Dao.CourseDao;
import com.app.Dao.StudentDao;
import com.app.Pojos.Course;
import com.app.Pojos.Student;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private ModelMapper model;

	@Override
	public String addStudent(StudentRequestDTO studentRequestDTO) {
		// TODO Auto-generated method stub
		Course c=courseDao.findById(studentRequestDTO.getCid()).orElseThrow();
		if(c!=null) {
			Student s=model.map(studentRequestDTO,Student.class);
			c.addStudent(s);
			studentDao.save(s);
			return "Student added successfully";
		}
		return "unable to add student record";
	}

	@Override
	public StudentRespDTO getStudent(String name) {
		// TODO Auto-generated method stub
		
		Student s=studentDao.findByFirstName(name);
		Course c=courseDao.findById(s.getCourse().getId()).orElseThrow();
		StudentRespDTO sr=new StudentRespDTO();
		sr.setCourseTitle(c.getCourse());
		sr.setEmail(s.getEmail());
		sr.setFirstName(s.getFirstName());
		sr.setLastName(s.getLastName());
		sr.setScoreObtained(s.getScoreObtained());
		return sr;
	}

	@Override
	public String cancelAdmission(Long id) {
		// TODO Auto-generated method stub
		System.out.println("inside cancelAdmission()");
		Student s=studentDao.findById(id).orElseThrow();
		System.out.println(s.getFirstName());
		Course c=s.getCourse();
		System.out.println(c.getCourse());
		if(c!=null) {
			c.removeStudent(s);
			courseDao.save(c);
			studentDao.delete(s);
		}
		
		return "admission cancelled for the student : "+s.getFirstName();
	}

}
