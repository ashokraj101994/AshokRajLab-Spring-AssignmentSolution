package com.greatlearning.StudentManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication

public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Bean
	public ViewResolver viewResolver() {
		final InternalResourceViewResolver r = new InternalResourceViewResolver();
		r.setPrefix("/WEB-INF/views/");
		r.setSuffix(".jsp");
		return r;
	}

}
