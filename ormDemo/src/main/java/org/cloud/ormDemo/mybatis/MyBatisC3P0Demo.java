package org.cloud.ormDemo.mybatis;

import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.cloud.ormDemo.model.Employee;

public class MyBatisC3P0Demo {

    public static void main(String[] args) {
        SqlSession session = MyBatisC3P0Util.getSqlSessionFactory().openSession();
        System.out.println("User info: " + getEmployeeById(session));
        session.close();
    }

    private static String getEmployeeById(SqlSession session) {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.getEmployeeByName(1L);
        return Optional.ofNullable(employee).map(u -> u.getName()).orElse("no body");
    }

}
