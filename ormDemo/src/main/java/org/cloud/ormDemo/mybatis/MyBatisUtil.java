package org.cloud.ormDemo.mybatis;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
    private static final String CONFIG_FILE = "mybatis/mybatis.xml";
    private static SqlSessionFactory sessionFactory;

    public static SqlSessionFactory getSqlSessionFactory() {

        if (sessionFactory == null) {
            try {
                sessionFactory = new SqlSessionFactoryBuilder()
                        .build(Resources.getResourceAsStream(CONFIG_FILE));
            } catch (IOException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}
