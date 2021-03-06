package hibernate.pon.al.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();
    private static StandardServiceRegistry serviceRegistry;

    public static SessionFactory buildSessionFactory(){
        serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        }catch (HibernateException e){
            e.printStackTrace();
            System.out.println("Error creating session" + e);
            throw new ExceptionInInitializerError(e);
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if(sessionFactory != null){
            sessionFactory.close();
        }
        if(serviceRegistry != null){StandardServiceRegistryBuilder.destroy(serviceRegistry);}
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
