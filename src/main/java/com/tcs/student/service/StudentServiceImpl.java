package com.tcs.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.student.entity.Student;
import com.tcs.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAll() {
		List<Student> getAllStudents = studentRepository.findAll();
		return getAllStudents;
	}

	@Override
	public Student getById(int rollNo) {
		Optional<Student> student = studentRepository.findById(rollNo);
		return student.get();
	}

	@Override
	public Student create(Student student) {

		return studentRepository.save(student);
	}

}
