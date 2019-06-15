package org.cloud.springmvcDemo.service;

import java.util.List;

import org.cloud.springmvcDemo.model.Employee;

public interface EmployeeService {
    Employee find(long id);
    
    void addEmployee(Employee employee);
    
    void deleteEmployee(long id);
    
    void updateEmployee(Employee employee);
    
    List<Employee> getAllEmployees();
}
