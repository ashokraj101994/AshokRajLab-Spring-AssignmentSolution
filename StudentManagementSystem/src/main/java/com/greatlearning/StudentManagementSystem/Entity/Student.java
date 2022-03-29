package com.greatlearning.StudentManagementSystem.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Student")
public class Student {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Department")
	private String department;

	@Column(name = "Country")
	private String country;

	public Student(String name, String department, String country) {
		super();
		this.name = name;
		this.department = department;
		this.country = country;
	}

}
