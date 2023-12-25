package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.CourseResDTO;
import com.app.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/getCourse/{id}")
	public ResponseEntity<CourseResDTO> getCourse(@PathVariable Long id){
		return ResponseEntity.ok(courseService.getCourse(id));
	}
	
	@PutMapping("/updateFee/{id}/fee/{offSet}")
	public ResponseEntity<String> updateFee(@PathVariable Long id,@PathVariable int offSet){
		return ResponseEntity.ok(courseService.updateFee(id, offSet));
	}
}
