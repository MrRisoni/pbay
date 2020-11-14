package models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static EntityManager em = null;
    public static EntityManager getEM() {
        if (em == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ebaydb");
            em = entityManagerFactory.createEntityManager();
        }
        return em;
    }
}