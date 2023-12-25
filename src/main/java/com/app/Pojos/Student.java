package com.app.Pojos;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name="student")
@Getter
@Setter
@ToString
public class Student extends BaseEntity {
	private String firstName;
	private String lastName;
	private String email;
	private double scoreObtained;
	@ManyToOne
	@JoinColumn(name="cid",nullable = true)
	private Course course;
	public Student() {
	
	}
	public Student(String firstName, String lastName, String email,double scoreObtained) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.scoreObtained=scoreObtained;
	}
	
	
}
