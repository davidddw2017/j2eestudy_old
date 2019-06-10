package org.cloud.ssh.action;

import java.util.List;

import org.cloud.ssh.entity.Student;
import org.cloud.ssh.service.StudentService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentAction extends ActionSupport implements ModelDriven<Student> {

    private static final long serialVersionUID = 1L;
    
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    private Student student;
    
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    // list all customers
    public String listStudent() throws Exception {
        List<Student> listStudent = studentService.listStudent();
        ObjectMapper mapper = new ObjectMapper();
        result = mapper.writeValueAsString(listStudent);
        return SUCCESS;
    }

    // save customer
    public String addStudent() throws Exception {
        studentService.addStudent(student);
        return SUCCESS;
    }
    
    // delete customer
    public String deleteStudent() throws Exception {
        studentService.deleteStudent(student.getId());
        return SUCCESS;
    }

    @Override
    public Student getModel() {
        if(student == null){
            student = new Student();
        }
        return student;
    }
}
