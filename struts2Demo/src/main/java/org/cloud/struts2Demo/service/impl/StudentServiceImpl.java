package org.cloud.struts2Demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.cloud.struts2Demo.model.Student;
import org.cloud.struts2Demo.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, "张三", "jilin", 20));
        studentList.add(new Student(2, "李四", "beijing", 25));
        studentList.add(new Student(3, "王五", "shanghai", 22));
    }

    private int findLocation(long id) {
        int target = -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                target = i;
                break;
            }
        }
        return target;
    }

    private long findStudentMaxId() {
        long maxId = 0;
        for (Student student : studentList) {
            if (maxId < student.getId()) {
                maxId = student.getId();
            }
        }
        return maxId;
    }

    @Override
    public Student find(long id) {
        return studentList.get(findLocation(id));
    }

    @Override
    public void addStudent(Student student) {
        if (student == null) {
            throw new RuntimeException("add kong");
        }
        student.setId(findStudentMaxId() + 1);
        studentList.add(student);
    }

    @Override
    public void deleteStudent(long id) {
        int target = findLocation(id);
        if (target != -1)
            studentList.remove(target);
    }

    @Override
    public void updateStudent(Student student) {
        if (student == null) {
            throw new RuntimeException("update kong");
        }
        int position = findLocation(student.getId());
        Student student2 = new Student(student.getId(), student.getName(), student.getAddress(), student.getAge());
        studentList.set(position, student2);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }

}
