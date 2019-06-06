package org.cloud.ormDemo.mybatis;

import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.cloud.ormDemo.model.User;

public class MyBatisC3P0Demo {

    public static void main(String[] args) {
        SqlSession session = MyBatisC3P0Util.getSqlSessionFactory().openSession();
        System.out.println("User info: " + getUserById(session));
        session.close();
    }

    private static String getUserById(SqlSession session) {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.getUserByName(1L);
        return Optional.ofNullable(user).map(u -> u.getName()).orElse("no body");
    }

}
