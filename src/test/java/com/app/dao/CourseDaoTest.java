package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.Dao.CourseDao;
import com.app.Pojos.Course;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CourseDaoTest {
	@Autowired
	private CourseDao courseDao;
	
	@Test
	void populateCourse() {
		List<Course> clist=List.of(
				new Course("JAVA", LocalDate.parse("2020-01-02"), LocalDate.parse("2021-02-02"), 3500, 56),
				new Course("WPT", LocalDate.parse("2021-01-02"), LocalDate.parse("2022-02-02"), 4500, 66),
				new Course("DBT", LocalDate.parse("2022-01-02"), LocalDate.parse("2023-02-02"), 5500, 55)
				);
		courseDao.saveAll(clist);
	}
}
