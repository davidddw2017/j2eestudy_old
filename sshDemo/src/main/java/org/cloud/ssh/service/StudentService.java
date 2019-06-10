package org.cloud.ssh.service;

import java.util.List;

import org.cloud.ssh.entity.Student;

public interface StudentService {
    void addStudent(Student student);

    List<Student> listStudent();

    void deleteStudent(int studentID);
}
