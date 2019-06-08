package org.cloud.springmvcDemo.service;

import java.util.List;

import org.cloud.springmvcDemo.model.Student;

public interface StudentService {
    Student find(long id);
    
    void addStudent(Student student);
    
    void deleteStudent(long id);
    
    void updateStudent(Student student);
    
    List<Student> getAllStudents();
}
