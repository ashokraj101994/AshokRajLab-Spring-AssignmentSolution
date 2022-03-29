package com.greatlearning.StudentManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.greatlearning.StudentManagementSystem.Entity.Users;


public interface UserRepository extends JpaRepository<Users, Integer> {

	@Query("select u from Users u where u.username=?1")
	public Users getUserByUserName(String username);
}
