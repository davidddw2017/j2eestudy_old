package org.cloud.ssh.service.impl;

import java.util.List;

import org.cloud.ssh.dao.StudentDAO;
import org.cloud.ssh.entity.Student;
import org.cloud.ssh.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    @Override
    public List<Student> listStudent() {
        return studentDAO.listStudent();
    }

    @Override
    public void deleteStudent(int studentID) {
        studentDAO.deleteStudent(studentID);
    }
}
