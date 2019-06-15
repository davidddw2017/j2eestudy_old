package org.cloud.ssh.dao.impl;

import java.util.List;

import org.cloud.ssh.dao.EmployeeDAO;
import org.cloud.ssh.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDAOImpl implements EmployeeDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(employee);
        tx.commit();
        session.close();
    }

    @Override
    public List<Employee> listEmployee() {
        Session session = sessionFactory.openSession();
        String hql = "from Employee s order by s.id";
        List<Employee> res = session.createQuery(hql, Employee.class).list();
        session.close();
        return res;
    }

    @Override
    public void deleteEmployee(int employeeID) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        // 获取对象
        Employee u = (Employee) session.get(Employee.class, employeeID);
        session.delete(u);
        tx.commit();
        session.close();
    }

}
