package org.cloud.ssh.action;

import java.util.List;

import org.cloud.ssh.entity.Employee;
import org.cloud.ssh.service.EmployeeService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {

    private static final long serialVersionUID = 1L;
    
    private EmployeeService EmployeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.EmployeeService = employeeService;
    }

    private Employee employee;
    
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    // list all customers
    public String listEmployee() throws Exception {
        List<Employee> listEmployee = EmployeeService.listEmployee();
        ObjectMapper mapper = new ObjectMapper();
        result = mapper.writeValueAsString(listEmployee);
        return SUCCESS;
    }

    // save customer
    public String addEmployee() throws Exception {
        EmployeeService.addEmployee(employee);
        return SUCCESS;
    }
    
    // delete customer
    public String deleteEmployee() throws Exception {
        EmployeeService.deleteEmployee(employee.getId());
        return SUCCESS;
    }

    @Override
    public Employee getModel() {
        if(employee == null){
            employee = new Employee();
        }
        return employee;
    }
}
