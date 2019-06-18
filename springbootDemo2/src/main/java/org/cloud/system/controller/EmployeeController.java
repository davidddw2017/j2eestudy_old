package org.cloud.system.controller;

import java.util.List;

import org.cloud.system.model.Employee;
import org.cloud.system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/employee")
public class EmployeeController {
	
	private static final String SUCCESS = "success";

	@Autowired
	private EmployeeService service;

	@GetMapping("/listEmployee")
	public @ResponseBody List<Employee> listEmployee() {
		List<Employee> listEmployee = service.listEmployee();
		return listEmployee;
	}

	@PostMapping(value = "/addEmployee")
	public @ResponseBody String addEmployee(Employee employee) {
		service.addEmployee(employee);
		return SUCCESS;
	}
	
	@GetMapping("/getEmployee/{employeeId}")
    public @ResponseBody Employee getEmployee(@PathVariable Long employeeId) {
	    return service.getEmployee(employeeId);
    }
	
	@PutMapping("/updateEmployee")
    public @ResponseBody String updateEmployee(Employee employee) {
        service.updateEmployee(employee);
        return SUCCESS;
    }

	@DeleteMapping(value= "/deleteEmployee/{employeeId}")
	public @ResponseBody String deleteEmployee(@PathVariable Long employeeId) {
		service.deleteEmployee(employeeId);
		return SUCCESS;
	}

}
