package org.cloud.ormDemo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import junit.framework.TestCase;

public class HibernateDemoTest extends TestCase {
    
    private static Session session;
    private static SessionFactory sessionFactory;

    protected void setUp() throws Exception {
        super.setUp();
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        session.close();
        //sessionFactory.close();
    }

    @Test
    public void testGetNamedQuery() {
        System.out.println("User info: " + HibernateDemo.getNamedQuery(session));
    }

    @Test
    public void testNormalQuery() {
        System.out.println("User info: " + HibernateDemo.normalQuery(session));
    }

    @Test
    public void testNormalHQLQuery1() {
        System.out.println("User info: " + HibernateDemo.normalHQLQuery1(session));
    }

    @Test
    public void testNormalHQLQuery2() {
        System.out.println("User info: " + HibernateDemo.normalHQLQuery2(session));
    }
}
