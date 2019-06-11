package org.cloud.ssm.service.impl;

import java.util.List;

import org.cloud.ssm.entity.Student;
import org.cloud.ssm.mapper.StudentMapper;
import org.cloud.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    @Override
    public List<Student> listStudent() {
        return studentMapper.listStudent();
    }

    @Override
    public void deleteStudent(long studentID) {
        studentMapper.deleteStudent(studentID);
    }
}
