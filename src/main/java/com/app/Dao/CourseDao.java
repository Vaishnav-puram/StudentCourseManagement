package com.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Pojos.Course;

@Repository
public interface CourseDao extends JpaRepository<Course,Long> {

}
