package org.cloud.struts2Demo.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.cloud.struts2Demo.model.Employee;
import org.cloud.struts2Demo.service.EmployeeService;
import org.cloud.struts2Demo.service.impl.EmployeeServiceImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>, Preparable {

    private EmployeeService service = new EmployeeServiceImpl();

    private static final long serialVersionUID = 1L;

    private static final String LIST = "list";
    private static final String DELETE = "delete";
    private static final String SAVE = "save";
    private static final String UPDATE = "update";
    private static final String ADD = "add";

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeService getService() {
        return service;
    }

    public void setService(EmployeeService service) {
        this.service = service;
    }

    private List<Employee> employeeList;
    
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public Employee getModel() {
        if (employee == null) {
            employee = new Employee();
        }
        return employee;
    }

    public String list() throws Exception {
        employeeList = service.getAllEmployees();
        return LIST;
    }

    public String preSave() throws Exception {
        if (null != employee.getId()) {
            employee = service.find(employee.getId());
            ServletActionContext.getRequest().setAttribute("Employee", employee);
            return UPDATE;
        } else {
            return ADD;
        }
    }

    public String save() throws Exception {
        if (employee.getId() != null) {
            service.updateEmployee(employee);
        } else {
            service.addEmployee(employee);
        }
        return SAVE;
    }

    public String delete() throws Exception {
        service.deleteEmployee(employee.getId());
        return DELETE;
    }

    @Override
    public void prepare() throws Exception {

    }

}
