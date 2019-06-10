package org.cloud.ssh.dao;

import java.util.List;

import org.cloud.ssh.entity.Student;

public interface StudentDAO {
    void addStudent(Student student);

    List<Student> listStudent();
    
    void deleteStudent(int studentID);
}
