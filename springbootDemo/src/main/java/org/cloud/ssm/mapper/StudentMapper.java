package org.cloud.ssm.mapper;

import java.util.List;

import org.cloud.ssm.model.Student;

public interface StudentMapper {
    void addStudent(Student student);

    List<Student> listStudent();
    
    void deleteStudent(long studentID);
}
