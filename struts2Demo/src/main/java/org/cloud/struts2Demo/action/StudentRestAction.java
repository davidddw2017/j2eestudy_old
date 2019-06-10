package org.cloud.struts2Demo.action;

import java.util.List;

import org.cloud.struts2Demo.model.Student;
import org.cloud.struts2Demo.service.StudentService;
import org.cloud.struts2Demo.service.impl.StudentServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentRestAction extends ActionSupport implements ModelDriven<Student> {

	private static final long serialVersionUID = 1L;
	
	private StudentService studentService = new StudentServiceImpl();

	private Student student;

	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

	@Override
	public Student getModel() {
		if(student == null){
            student = new Student();
        }
        return student;
	}
	
	public String listStudent() throws Exception {
        List<Student> listStudent = studentService.getAllStudents();
        ObjectMapper mapper = new ObjectMapper();
        result = mapper.writeValueAsString(listStudent);
        return SUCCESS;
    }
	
	public String addStudent() throws Exception {
        studentService.addStudent(student);
        return SUCCESS;
    }
	
	public String deleteStudent() throws Exception {
        studentService.deleteStudent(student.getId());
        return SUCCESS;
    }

}
