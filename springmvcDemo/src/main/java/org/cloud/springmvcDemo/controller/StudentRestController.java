package org.cloud.springmvcDemo.controller;

import java.util.List;

import org.cloud.springmvcDemo.model.Student;
import org.cloud.springmvcDemo.service.StudentService;
import org.cloud.springmvcDemo.service.impl.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/student")
public class StudentRestController {
	
	private static final String SUCCESS = "success";

	private StudentService service = new StudentServiceImpl();

	public StudentService getService() {
		return service;
	}

	public void setService(StudentService service) {
		this.service = service;
	}

	@RequestMapping("/listStudent")
	public @ResponseBody List<Student> listStudent() {
		List<Student> listStudent = service.getAllStudents();
		return listStudent;
	}

	@RequestMapping(value = "/addStudent", method=RequestMethod.POST)
	public @ResponseBody String addStudent(Student student) {
		service.addStudent(student);
		return SUCCESS;
	}

	@RequestMapping(value= "/deleteStudent", method=RequestMethod.POST)
	public @ResponseBody String deleteStudent(Student student) {
		service.deleteStudent(student.getId());
		return SUCCESS;
	}

}
