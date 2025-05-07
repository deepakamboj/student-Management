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

	@Override
	public void delete(int rollNo) {
		studentRepository.deleteById(rollNo);
	}
	@Override
	public Student update(Student newStudent,int rollNo) {
		Student oldStudent= studentRepository.findById(rollNo).get();
		//oldStudent.setRollNo(newStudent.getRollNo()); don't change rollno due to security of an id
		oldStudent.setAge(newStudent.getAge());
		oldStudent.setDob(newStudent.getDob());
		oldStudent.setFatherName(newStudent.getFatherName());
		oldStudent.setFees(newStudent.getFees());
		oldStudent.setName(newStudent.getName());
		return studentRepository.save(oldStudent);
	}

}
