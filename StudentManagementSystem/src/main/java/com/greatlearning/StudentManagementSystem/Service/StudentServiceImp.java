package com.greatlearning.StudentManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.greatlearning.StudentManagementSystem.Entity.Student;
import com.greatlearning.StudentManagementSystem.Repository.StudentRepository;

@Repository
public class StudentServiceImp implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> students() {
		// inbuilt Jpa Repository methods
		List<Student> student = studentRepository.findAll();
		return student;
	}

	@Override
	public Student findbyId(int stdId) {
		Student student = studentRepository.findById(stdId).get();
		return student;
	}

	@Override
	public void save(Student student) {
		studentRepository.save(student);

	}

	@Override
	public void deletebyId(int stdId) {
		studentRepository.deleteById(stdId);
	}

}
