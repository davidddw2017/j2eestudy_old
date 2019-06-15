package org.cloud.struts2Demo.action;

import java.util.List;

import org.cloud.struts2Demo.model.Employee;
import org.cloud.struts2Demo.service.EmployeeService;
import org.cloud.struts2Demo.service.impl.EmployeeServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeRestAction extends ActionSupport implements ModelDriven<Employee> {

	private static final long serialVersionUID = 1L;
	
	private EmployeeService employeeService = new EmployeeServiceImpl();

	private Employee employee;

	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

	@Override
	public Employee getModel() {
		if(employee == null){
		    employee = new Employee();
        }
        return employee;
	}
	
	public String listEmployee() throws Exception {
        List<Employee> listEmployee = employeeService.getAllEmployees();
        ObjectMapper mapper = new ObjectMapper();
        result = mapper.writeValueAsString(listEmployee);
        return SUCCESS;
    }
	
	public String addEmployee() throws Exception {
        employeeService.addEmployee(employee);
        return SUCCESS;
    }
	
	public String deleteEmployee() throws Exception {
        employeeService.deleteEmployee(employee.getId());
        return SUCCESS;
    }

}
