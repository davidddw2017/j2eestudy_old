package org.cloud.ssm.mapper;

import java.util.List;

import org.cloud.ssm.model.Employee;

public interface EmployeeMapper {
    void addEmployee(Employee employee);

    List<Employee> listEmployee();
    
    Employee getEmployee(long employeeID);
    
    void updateEmployee(Employee employee);
    
    void deleteEmployee(long employeeID);
}
