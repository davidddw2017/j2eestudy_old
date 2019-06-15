package org.cloud.struts2Demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.cloud.struts2Demo.model.Employee;
import org.cloud.struts2Demo.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    private static List<Employee> employeeList = new ArrayList<>();

    static {
        employeeList.add(new Employee(1, "张三", "jilin", 20));
        employeeList.add(new Employee(2, "李四", "beijing", 25));
        employeeList.add(new Employee(3, "王五", "shanghai", 22));
    }

    private int findLocation(long id) {
        int target = -1;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                target = i;
                break;
            }
        }
        return target;
    }

    private long findEmployeeMaxId() {
        long maxId = 0;
        for (Employee employee : employeeList) {
            if (maxId < employee.getId()) {
                maxId = employee.getId();
            }
        }
        return maxId;
    }

    @Override
    public Employee find(long id) {
        return employeeList.get(findLocation(id));
    }

    @Override
    public void addEmployee(Employee employee) {
        if (employee == null) {
            throw new RuntimeException("add kong");
        }
        employee.setId(findEmployeeMaxId() + 1);
        employeeList.add(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        int target = findLocation(id);
        if (target != -1)
            employeeList.remove(target);
    }

    @Override
    public void updateEmployee(Employee employee) {
        if (employee == null) {
            throw new RuntimeException("update kong");
        }
        int position = findLocation(employee.getId());
        Employee employee2 = new Employee(employee.getId(), employee.getName(), employee.getAddress(), employee.getAge());
        employeeList.set(position, employee2);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

}
