package com.tcs.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

import com.tcs.student.entity.Student;
import com.tcs.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/create")
	public Student create(@RequestBody Student student) {
		Student createstudent = studentService.create(student);
		return createstudent;
	}

	@GetMapping("/getAll")
	public List<Student> getAll() {
		List<Student> getAllstudents = studentService.getAll();
		return getAllstudents;
	}

	@GetMapping("/get/{rollNo}")
	public Student getById(@PathVariable int rollNo) {
		return studentService.getById(rollNo);
	}

	@DeleteMapping("/delete/{rollNo}")
	public String delete(@PathVariable int rollNo) {
		studentService.delete(rollNo);
		return "Record successfully deleted";

	}
	@PutMapping("/update/{rollNo}")
	public Student update(@RequestBody Student student,@PathVariable int rollNo) {
		return studentService.update(student, rollNo);
	}
	

}
