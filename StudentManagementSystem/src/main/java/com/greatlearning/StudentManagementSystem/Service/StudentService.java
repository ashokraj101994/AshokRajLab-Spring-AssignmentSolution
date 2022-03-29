package com.greatlearning.StudentManagementSystem.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.StudentManagementSystem.Entity.Student;

@Service
public interface StudentService {

	public List<Student> students();

	public Student findbyId(int StdId);

	public void save(Student student);

	public void deletebyId(int stdId);
}
