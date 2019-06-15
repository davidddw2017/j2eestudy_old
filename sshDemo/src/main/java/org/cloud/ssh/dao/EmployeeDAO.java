package org.cloud.ssh.dao;

import java.util.List;

import org.cloud.ssh.entity.Employee;

public interface EmployeeDAO {
    void addEmployee(Employee employee);

    List<Employee> listEmployee();
    
    void deleteEmployee(int employeeID);
}
