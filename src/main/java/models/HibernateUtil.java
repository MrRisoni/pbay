package models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {
    private static EntityManager em = null;
    private static EntityManagerFactory emFactory = null;

    public static EntityManager getEM() {

        if (emFactory == null) {
            System.out.println("SETTING UP EntityManager");
            System.out.println("CREATING NEW EM");
            Map<String, Object> configOverrides = new HashMap<String, Object>();
            configOverrides.put("javax.persistence.jdbc.password", System.getenv("MSSQL_PASSWD"));
            configOverrides.put("javax.persistence.jdbc.user", System.getenv("MSSQL_USR"));

            configOverrides.put("javax.persistence.jdbc.url", "jdbc:sqlserver://localhost;databaseName=pbaydb");

            emFactory = Persistence.createEntityManagerFactory("ebaymssql", configOverrides);
            em = emFactory.createEntityManager();
        }
        return em;
    }
}