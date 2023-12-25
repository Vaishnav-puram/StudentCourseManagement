package com.app.DTO;

import java.time.LocalDate;
import java.util.List;

import lombok.*;


@Getter
@Setter
public class CourseResDTO {
	private String course;
	private LocalDate startDate;
	private LocalDate endDate;
	private int fees;
	private int minScore;	
	List<StudentRespDTO> students;
}
