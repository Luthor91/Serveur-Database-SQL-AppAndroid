package com.example.shopOnline.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create registry
                registry = new StandardServiceRegistryBuilder().
                        configure().build();

                // Create MetadataSources
                MetadataSources sources =
                        new MetadataSources(registry);

                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().
                        build();

                // Create SessionFactory
                sessionFactory = metadata.
                        getSessionFactoryBuilder().build();

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static boolean create(Object o){
        Transaction transaction=null;
        try(Session session=getSessionFactory().openSession()) {
        transaction=session.beginTransaction();
        session.persist(o);
        transaction.commit();
        return true;
        }catch (Exception ex){
            ex.printStackTrace();
            if(transaction!=null) {
                    transaction.rollback();
            }

        }
        return false;
    }
    public static boolean delete(Object o){
        Transaction transaction=null;
        try(Session session=getSessionFactory().openSession()) {
            transaction=session.beginTransaction();
            session.remove(o);
            transaction.commit();
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            if(transaction!=null) {
                transaction.rollback();
            }

        }
        return false;
    }

    public static Object update(Object o){
        Transaction transaction=null;
        try(Session session=getSessionFactory().openSession()) {
            transaction=session.beginTransaction();
            Object oU=session.merge(o);
            transaction.commit();
            return oU;
        }catch (Exception ex){
            ex.printStackTrace();
            if(transaction!=null) {
                transaction.rollback();
            }

        }
        return null;
    }
    public static Object getByID(Object id,Class c){
        try(Session session=getSessionFactory().openSession()) {
            Object oU=session.find(c,id);
            return oU;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static boolean removeByID(Object id,Class c){
        Transaction transaction=null;
        try(Session session=getSessionFactory().openSession()) {
            transaction=session.beginTransaction();
            Object o=getByID(id,c);
            session.remove(o);
            transaction.commit();
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            if(transaction!=null) {
                transaction.rollback();
            }

        }
        return false;
    }
    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}