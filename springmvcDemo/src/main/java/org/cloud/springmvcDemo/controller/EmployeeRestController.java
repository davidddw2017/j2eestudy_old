package org.cloud.springmvcDemo.controller;

import java.util.List;

import org.cloud.springmvcDemo.model.Employee;
import org.cloud.springmvcDemo.service.EmployeeService;
import org.cloud.springmvcDemo.service.impl.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/employee")
public class EmployeeRestController {
	
	private static final String SUCCESS = "success";

	private EmployeeService service = new EmployeeServiceImpl();

	public EmployeeService getService() {
		return service;
	}

	public void setService(EmployeeService service) {
		this.service = service;
	}

	@RequestMapping("/listEmployee")
	public @ResponseBody List<Employee> listEmployee() {
		List<Employee> listEmployee = service.getAllEmployees();
		return listEmployee;
	}

	@RequestMapping(value = "/addEmployee", method=RequestMethod.POST)
	public @ResponseBody String addEmployee(Employee employee) {
		service.addEmployee(employee);
		return SUCCESS;
	}

	@RequestMapping(value= "/deleteEmployee", method=RequestMethod.POST)
	public @ResponseBody String deleteEmployee(Employee employee) {
		service.deleteEmployee(employee.getId());
		return SUCCESS;
	}

}
