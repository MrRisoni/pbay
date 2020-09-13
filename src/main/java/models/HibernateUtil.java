package models;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {


    private static EntityManager em = null;

    public static EntityManager getEM() {
        if (em == null) {
            Map<String, Object> configOverrides = new HashMap<String, Object>();
            System.out.println("SYSTEM ENV");
            configOverrides.put("javax.persistence.jdbc.password", System.getenv("SPRING_APP_DB_EBAY_PASSWD"));
            configOverrides.put("javax.persistence.jdbc.user",  System.getenv("SPRING_APP_DB_EBAY_USR"));
            String dbUrl = "jdbc:mysql://" + System.getenv("SPRING_APP_DB_EBAY_HOST") + ":3306/" + System.getenv("SPRING_APP_DB_EBAY_NAME") + "?serverTimezone=UTC";
            configOverrides.put("javax.persistence.jdbc.url", dbUrl);
            System.out.println("URL CON");
            System.out.println(dbUrl);


            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ebaydb", configOverrides);
            em = entityManagerFactory.createEntityManager();
        }
        return em;
    }

}