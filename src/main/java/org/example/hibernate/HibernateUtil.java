package org.example.hibernate;

import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private  static  final  HibernateUtil INSTANCE;
    private SessionFactory sessionFactory;
    static {
        INSTANCE = new HibernateUtil();
    }


    private HibernateUtil(){
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
        Flyway flyway = Flyway.configure()

                .dataSource("jdbc:h2:./company",null,null)
                .locations("migration")
                .load();

        flyway.migrate();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }
    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public void close(){
        sessionFactory.close();
    }
}
