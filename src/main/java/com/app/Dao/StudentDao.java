package com.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Pojos.Student;

@Repository
public interface StudentDao extends JpaRepository<Student,Long> {
	Student findByFirstName(String name);
}
