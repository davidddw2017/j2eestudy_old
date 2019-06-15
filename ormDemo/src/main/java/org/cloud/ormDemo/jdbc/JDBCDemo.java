package org.cloud.ormDemo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.cloud.ormDemo.model.Employee;

public class JDBCDemo {

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://db.cloud.org:3306/mydb";
            String user = "cloud";
            String password = "passwd";
            connection = (Connection) DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return connection;
    }

    public Employee getEmployee(long id) {
        Connection connection = getConnection();
        PreparedStatement pStatement = null;
        ResultSet rSet = null;
        String sql = "select * from t_employee where id = ?";
        try {
            pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, id);
            rSet = pStatement.executeQuery();
            while (rSet.next()) {
                int g_id = rSet.getInt("id");
                String name = rSet.getString("name");
                String address = rSet.getString("address");
                int age = rSet.getInt("age");
                return new Employee(g_id, name, address, age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        JDBCDemo jdbcDemo = new JDBCDemo();
        Employee employee = jdbcDemo.getEmployee(1L);
        if(employee != null) {
            System.out.println("User info: " + employee);
        }
    }

}
