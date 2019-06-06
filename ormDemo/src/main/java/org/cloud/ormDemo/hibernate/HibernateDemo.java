package org.cloud.ormDemo.hibernate;

import java.util.Optional;

import org.cloud.ormDemo.model.User;
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
        User user = new User("ddw", "beijing", 20);
        session.save(user);
        tx.commit();
    }

    public static String getNamedQuery(Session session) {
        Query<User> query = session.createNamedQuery("getUserByName", User.class);
        query.setParameter("id", 1L);
        User user = query.uniqueResult();
        return Optional.ofNullable(user).map(u -> u.getName()).orElse("no body");
    }

    public static String normalQuery(Session session) {
        User user = session.get(User.class, 1L);
        return Optional.ofNullable(user).map(u -> u.getName()).orElse("no body");
    }

    public static String normalHQLQuery1(Session session) {
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from User where id = :id";
        User user = session.createQuery(hql, User.class).setParameter("id", 1L).uniqueResult();
        return Optional.ofNullable(user).map(u -> u.getName()).orElse("no body");
    }

    public static String normalHQLQuery2(Session session) {
        String sql = "SELECT * FROM t_person where id = :id";
        NativeQuery<User> query = session.createNativeQuery(sql, User.class);
        User user = query.setParameter("id", 1L).uniqueResult();
        return Optional.ofNullable(user).map(u -> u.getName()).orElse("no body");
    }
}
