package org.cloud.ssm.controller;

import java.util.List;

import org.cloud.ssm.entity.Student;
import org.cloud.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/student")
public class StudentController {
	
	private static final String SUCCESS = "success";

	@Autowired
	private StudentService service;

	@RequestMapping("/listStudent")
	public @ResponseBody List<Student> listStudent() {
		List<Student> listStudent = service.listStudent();
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
