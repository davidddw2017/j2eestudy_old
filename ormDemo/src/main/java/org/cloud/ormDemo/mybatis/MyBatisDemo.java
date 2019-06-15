package org.cloud.ormDemo.mybatis;

import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.cloud.ormDemo.model.Employee;

public class MyBatisDemo {

    public static void main(String[] args) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        System.out.println("User info: " + getUserById(session));
        session.close();
    }

    private static String getUserById(SqlSession session) {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.getEmployeeByName(1L);
        return Optional.ofNullable(employee).map(u -> u.getName()).orElse("no body");
    }

}
