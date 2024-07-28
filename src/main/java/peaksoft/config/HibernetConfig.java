package peaksoft.config;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.entity.Course;

import java.util.Properties;

public class HibernetConfig {
    public static EntityManagerFactory getEntityManagerFactory() {
        try {
            Properties properties = new Properties();
            properties.put(Environment.JAKARTA_JDBC_DRIVER,"org.postgresql.Driver");
            properties.put(Environment.JAKARTA_JDBC_URL,"jdbc:postgresql://localhost:5432/postgres");
            properties.put(Environment.JAKARTA_JDBC_USER,"postgres");
            properties.put(Environment.JAKARTA_JDBC_PASSWORD,"3223");
            properties.put(Environment.HBM2DDL_AUTO,"create");
            properties.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
            properties.put(Environment.SHOW_SQL,"true");

            Configuration configuration = new Configuration();
            configuration.addProperties(properties);
            configuration.addAnnotatedClass(Course.class);

            return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);

        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

}
