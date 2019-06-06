package org.cloud.ormDemo.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final String CONFIG_FILE = "hibernate/hibernate.cfg.xml";
    
    private static SessionFactory sessionFactory;
    
    static {
        sessionFactory = new Configuration().configure(CONFIG_FILE).buildSessionFactory();
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
