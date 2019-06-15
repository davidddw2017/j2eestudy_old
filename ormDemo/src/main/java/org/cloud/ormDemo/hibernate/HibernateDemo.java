package org.cloud.ormDemo.hibernate;

import java.util.Optional;

import org.cloud.ormDemo.model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class HibernateDemo {

    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            System.out.println("User info: " + normalQuery(session));
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void savePerson(Session session) {
        Transaction tx = session.beginTransaction();
        Employee user = new Employee("ddw", "beijing", 20);
        session.save(user);
        tx.commit();
    }

    public static String getNamedQuery(Session session) {
        Query<Employee> query = session.createNamedQuery("getEmployeeByName", Employee.class);
        query.setParameter("id", 1L);
        Employee user = query.uniqueResult();
        return Optional.ofNullable(user).map(u -> u.getName()).orElse("no body");
    }

    public static String normalQuery(Session session) {
        Employee employee = session.get(Employee.class, 1L);
        return Optional.ofNullable(employee).map(u -> u.getName()).orElse("no body");
    }

    public static String normalHQLQuery1(Session session) {
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Employee where id = :id";
        Employee employee = session.createQuery(hql, Employee.class).setParameter("id", 1L).uniqueResult();
        return Optional.ofNullable(employee).map(u -> u.getName()).orElse("no body");
    }

    public static String normalHQLQuery2(Session session) {
        String sql = "SELECT * FROM t_employee where id = :id";
        NativeQuery<Employee> query = session.createNativeQuery(sql, Employee.class);
        Employee user = query.setParameter("id", 1L).uniqueResult();
        return Optional.ofNullable(user).map(u -> u.getName()).orElse("no body");
    }
}
