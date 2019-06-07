package org.cloud.springmvcDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.cloud.springmvcDemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class UserController {

    private static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, "张三", "jilin", 20));
        studentList.add(new Student(2, "李四", "beijing", 25));
        studentList.add(new Student(3, "王五", "shanghai", 22));
    }

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("student/studentList");
        modelAndView.addObject("studentList", studentList);
        return modelAndView;
    }

    private int getStudentById(long id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private long getStudentMaxId() {
        long maxId = 0;
        for (Student student : studentList) {
            if (maxId < student.getId()) {
                maxId = student.getId();
            }
        }
        return maxId;
    }

    @RequestMapping("/preSave")
    public ModelAndView preSave(@RequestParam(value = "id", required = false) Long id) {
        ModelAndView modelAndView = new ModelAndView();
        if (null != id) {
            modelAndView.addObject("student", studentList.get(getStudentById(id)));
            modelAndView.setViewName("student/update");
        } else {
            modelAndView.setViewName("student/add");
        }
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Student student) {
        if (student.getId() != 0) {
            int position = getStudentById(student.getId());
            Student student2 = new Student(student.getId(), student.getName(), student.getAddress(), student.getAge());
            studentList.set(position, student2);
        } else {
            student.setId(getStudentMaxId() + 1);
            studentList.add(student);
        }
        return "redirect:/student/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "id", required = true) Long id) {
        int position = getStudentById(id);
        studentList.remove(position);
        return "redirect:/student/list";
    }
}
