package org.cloud.ormDemo.mybatis;

import org.cloud.ormDemo.model.Employee;

public interface EmployeeMapper {
    Employee getEmployeeByName(long id);
}
