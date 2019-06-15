package org.cloud.struts2Demo.service;

import java.util.List;

import org.cloud.struts2Demo.model.Employee;

public interface EmployeeService {
    Employee find(long id);
    
    void addEmployee(Employee employee);
    
    void deleteEmployee(long id);
    
    void updateEmployee(Employee employee);
    
    List<Employee> getAllEmployees();
}
