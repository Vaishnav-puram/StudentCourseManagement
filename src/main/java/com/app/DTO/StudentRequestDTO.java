package com.app.DTO;

import lombok.*;

@Getter
@Setter
public class StudentRequestDTO {
	private String firstName;
	private String lastName;
	private String email;
	private double scoreObtained;
	private Long cid;
}
