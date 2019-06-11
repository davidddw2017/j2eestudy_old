package org.cloud.ssm.mapper;

import java.util.List;

import org.cloud.ssm.entity.Student;

public interface StudentMapper {
    void addStudent(Student student);

    List<Student> listStudent();
    
    void deleteStudent(long studentID);
}
