package org.cloud.system.mapper;

import java.util.List;

import org.cloud.system.model.Employee;

public interface EmployeeMapper {
    void addEmployee(Employee employee);

    List<Employee> listEmployee();
    
    Employee getEmployee(long employeeID);
    
    void updateEmployee(Employee employee);
    
    void deleteEmployee(long employeeID);
}
