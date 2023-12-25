package com.app.Pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="course")
@Getter
@Setter
@ToString
public class Course extends BaseEntity {
	private String course;
	private LocalDate startDate;
	private LocalDate endDate;
	private int fees;
	private int minScore;
	@OneToMany(mappedBy = "course",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)	
	List<Student> students=new ArrayList<>();
	
	public void addStudent(Student s) {
		this.students.add(s);
		s.setCourse(this);
	}
	public void removeStudent(Student s) {
		this.students.remove(s);
		s.setCourse(null);
	}
	public Course() {
		
	}
	public Course(String course, LocalDate startDate, LocalDate endDate, int fees, int minScore) {
		this.course = course;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fees = fees;
		this.minScore = minScore;
	} 
	
	
	
}
