package com.greatlearning.StudentManagementSystem.controller;

import java.security.Principal;
import java.util.List;
import java.util.Collection;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

import com.greatlearning.StudentManagementSystem.Entity.Student;
import com.greatlearning.StudentManagementSystem.Service.StudentService;

@Controller
@RequestMapping("/Student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/list")
	public String student(Model theModel) {
		List<Student> student = studentService.students();
		theModel.addAttribute("Student", student);
		return "Student-list";

	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("Student", student);
		return "Student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForupdate(@RequestParam("stId") int stdId, Model themodel) {
		Student student = studentService.findbyId(stdId);
		themodel.addAttribute("Student", student);
		return "Student-form";
	}

	@PostMapping("/save")
	public String save(@RequestParam("stId") int stId, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {
		Student student;
		if (stId != 0) {
			student = studentService.findbyId(stId);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		} else {
			student = new Student(name, department, country);

		}
		studentService.save(student);
		return "redirect:/Student/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("stId") int id) {
		studentService.deletebyId(id);

		return "redirect:/Student/list";
	}

	@RequestMapping("/403")
	public ModelAndView accessDeniedPage(Principal user) {
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", user.getName() + "You do not have permission to Access the page");
		} else {
			model.addObject("msg", user.getName() + "You do not have permission to Access the page");
		}
		model.setViewName("403");
		return model;
	}
}