package org.cloud.ormDemo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaDemo {

    private static final String PERSISTENCE_UNIT_NAME = "psunit1";
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = emf.createEntityManager();
        Employee employee = entityManager.getReference(Employee.class, 1L);
        if (employee != null) {
            System.out.println("Employee info: " + employee);
        }
        entityManager.close();
        emf.close();
    }

}
