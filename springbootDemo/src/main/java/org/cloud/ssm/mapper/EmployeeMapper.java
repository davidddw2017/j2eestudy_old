package org.cloud.ssm.mapper;

import java.util.List;

import org.cloud.ssm.model.Employee;

public interface EmployeeMapper {
    void addEmployee(Employee employee);

    List<Employee> listEmployee();
    
    void deleteEmployee(long employeeID);
}
