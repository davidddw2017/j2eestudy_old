package org.cloud.struts2Demo.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.cloud.struts2Demo.model.Student;
import org.cloud.struts2Demo.service.StudentService;
import org.cloud.struts2Demo.service.impl.StudentServiceImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class StudentAction extends ActionSupport implements ModelDriven<Student>, Preparable {

    private StudentService service = new StudentServiceImpl();

    private static final long serialVersionUID = 1L;

    private static final String LIST = "list";
    private static final String DELETE = "delete";
    private static final String SAVE = "save";
    private static final String UPDATE = "update";
    private static final String ADD = "add";

    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentService getService() {
        return service;
    }

    public void setService(StudentService service) {
        this.service = service;
    }

    private List<Student> studentList;
    
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public Student getModel() {
        if (student == null) {
            student = new Student();
        }
        return student;
    }

    public String list() throws Exception {
        studentList = service.getAllStudents();
        return LIST;
    }

    public String preSave() throws Exception {
        if (null != student.getId()) {
            student = service.find(student.getId());
            ServletActionContext.getRequest().setAttribute("student", student);
            return UPDATE;
        } else {
            return ADD;
        }
    }

    public String save() throws Exception {
        if (student.getId() != null) {
            service.updateStudent(student);
        } else {
            service.addStudent(student);
        }
        return SAVE;
    }

    public String delete() throws Exception {
        service.deleteStudent(student.getId());
        return DELETE;
    }

    @Override
    public void prepare() throws Exception {

    }

}
