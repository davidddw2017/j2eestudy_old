package org.cloud.springmvcDemo.controller;

import org.cloud.springmvcDemo.model.Student;
import org.cloud.springmvcDemo.service.StudentService;
import org.cloud.springmvcDemo.service.impl.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService service = new StudentServiceImpl();
    
    public StudentService getService() {
        return service;
    }

    public void setService(StudentService service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("student/studentList");
        modelAndView.addObject("studentList", service.getAllStudents());
        return modelAndView;
    }

    @RequestMapping("/preSave")
    public ModelAndView preSave(@RequestParam(value = "id", required = false) Long id) {
        ModelAndView modelAndView = new ModelAndView();
        if (null != id) {
            modelAndView.addObject("student", service.find(id));
            modelAndView.setViewName("student/update");
        } else {
            modelAndView.setViewName("student/add");
        }
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Student student) {
        if (student.getId() != 0) {
            service.updateStudent(student);
        } else {
            service.addStudent(student);
        }
        return "redirect:/student/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "id", required = true) Long id) {
        service.deleteStudent(id);
        return "redirect:/student/list";
    }
}
