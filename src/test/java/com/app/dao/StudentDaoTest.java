package com.app.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.Dao.CourseDao;
import com.app.Dao.StudentDao;
import com.app.Pojos.Course;
import com.app.Pojos.Student;

@DataJpaTest
@AutoConfigureTestDatabase(replace =Replace.NONE)
@Rollback(false)
public class StudentDaoTest {
	
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private CourseDao courseDao;
	
	@Test
	void populateStudents() {
		Course c=courseDao.findById(1L).orElseThrow();
		List<Student> studentList=List.of(
				new Student("raghu", "ram", "raghu@gmail.com",78),
				new Student("farook","hajib","farook@gmail.com",88),
				new Student("sare","husain","sare@gmail.com",58)
				);
		studentList.forEach(s->c.addStudent(s));
		studentDao.saveAll(studentList);
	}
}
