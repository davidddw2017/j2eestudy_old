package org.cloud.ssh.service.impl;

import java.util.List;

import org.cloud.ssh.dao.EmployeeDAO;
import org.cloud.ssh.entity.Employee;
import org.cloud.ssh.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO EmployeeDAO;

    public EmployeeDAO getEmployeeDAO() {
        return EmployeeDAO;
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.EmployeeDAO = employeeDAO;
    }

    @Override
    public void addEmployee(Employee employee) {
        EmployeeDAO.addEmployee(employee);
    }

    @Override
    public List<Employee> listEmployee() {
        return EmployeeDAO.listEmployee();
    }

    @Override
    public void deleteEmployee(int employeeID) {
        EmployeeDAO.deleteEmployee(employeeID);
    }
}
