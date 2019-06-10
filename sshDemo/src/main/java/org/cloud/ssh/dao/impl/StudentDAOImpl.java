package org.cloud.ssh.dao.impl;

import java.util.List;

import org.cloud.ssh.dao.StudentDAO;
import org.cloud.ssh.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDAOImpl implements StudentDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addStudent(Student student) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();

    }

    @Override
    public List<Student> listStudent() {
        Session session = sessionFactory.openSession();
        String hql = "from Student s order by s.id desc";
        List<Student> res = session.createQuery(hql, Student.class).list();
        session.close();
        return res;
    }

    @Override
    public void deleteStudent(int studentID) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        // 获取对象
        Student u = (Student) session.get(Student.class, studentID);
        session.delete(u);
        tx.commit();
        session.close();

    }

}
