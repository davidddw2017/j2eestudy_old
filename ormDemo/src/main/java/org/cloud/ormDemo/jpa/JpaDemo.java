package org.cloud.ormDemo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaDemo {

    private static final String PERSISTENCE_UNIT_NAME = "psunit1";
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = emf.createEntityManager();
        Person person = entityManager.getReference(Person.class, 1L);
        if (person != null) {
            System.out.println("Person info: " + person);
        }
        entityManager.close();
        emf.close();
    }

}
