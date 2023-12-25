package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.StudentRequestDTO;
import com.app.DTO.StudentRespDTO;
import com.app.service.StudentService;



@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addStud")
	public ResponseEntity<String> addStudent(@RequestBody StudentRequestDTO studentRequestDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(studentRequestDTO));
	}
	
	@GetMapping("/getStudent/{name}")
	public ResponseEntity<StudentRespDTO> getStudent(@PathVariable String name){
		return ResponseEntity.ok().body(studentService.getStudent(name));
	}
	
	@DeleteMapping("cancelAdmission/{id}")
	public ResponseEntity<String> cancelAdmission(@PathVariable Long id){
		return ResponseEntity.ok(studentService.cancelAdmission(id));
	}
}
