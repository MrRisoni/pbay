package entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static EntityManager em = null;

    private static ObjectMapper omp = new ObjectMapper();

    public static ObjectMapper getObjMapper() {
        omp.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return omp;
    }

    public static  EntityManager getEntityMngr()
    {
        if (em == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dickensdb");
            em = entityManagerFactory.createEntityManager();
        }
        return  em;
    }

    public static SessionFactory buildSessionFactory() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            return sessionFactory;
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            System.out.println("Exception at buildSessionFactory ");
            System.out.println(e.getMessage());
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
            return null;
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        sessionFactory.close();
    }

}