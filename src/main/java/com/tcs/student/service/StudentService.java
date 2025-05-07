package com.tcs.student.service;

import java.util.List;

import com.tcs.student.entity.Student;

public interface StudentService {

	public List<Student> getAll();

	public Student getById(int rollNo);

	public Student create(Student student);

	public void delete(int rollNo);

}
