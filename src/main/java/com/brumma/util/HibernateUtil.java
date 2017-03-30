package com.brumma.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil
{
    private static SessionFactory sessionFactory = createSessionFactory();

    private static Session session = createSession();

    public static SessionFactory createSessionFactory()
    {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure( "/hibernate.cfg.xml" ).build();
        try
        {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch ( Exception e )
        {
            StandardServiceRegistryBuilder.destroy( registry );
        }
        return sessionFactory;
    }

    public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public static Session createSession()
    {
        return sessionFactory.openSession();
    }

    public static Session getSession()
    {
        return session;
    }

    public static void shutdown()
    {
        sessionFactory.close();
    }
}
