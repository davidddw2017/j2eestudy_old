package org.cloud.springmvcDemo.controller;

import org.cloud.springmvcDemo.model.Employee;
import org.cloud.springmvcDemo.service.EmployeeService;
import org.cloud.springmvcDemo.service.impl.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService service = new EmployeeServiceImpl();
    
    public EmployeeService getService() {
        return service;
    }

    public void setService(EmployeeService service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("employee/employeeList");
        modelAndView.addObject("employeeList", service.getAllEmployees());
        return modelAndView;
    }

    @RequestMapping("/preSave")
    public ModelAndView preSave(@RequestParam(value = "id", required = false) Long id) {
        ModelAndView modelAndView = new ModelAndView();
        if (null != id) {
            modelAndView.addObject("employee", service.find(id));
            modelAndView.setViewName("employee/update");
        } else {
            modelAndView.setViewName("employee/add");
        }
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Employee employee) {
        if (employee.getId() != null) {
            service.updateEmployee(employee);
        } else {
            service.addEmployee(employee);
        }
        return "redirect:/employee/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "id", required = true) Long id) {
        service.deleteEmployee(id);
        return "redirect:/employee/list";
    }
}
